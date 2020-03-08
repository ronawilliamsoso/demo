package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.util.Date;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SessionDto implements SQLData {

    private String sqlType = "SESSION_RECTYPE";

    @Column(name = "ACTOR_IDENTIFIER")
    private String actorIdentifier;
    @Column(name = "SESSION_NUMBER")
    private long sessionNumber;
    @Column(name = "START_TIMESTAMP")
    private Timestamp startTimestamp;
    @Column(name = "END_TIMESTAMP")
    private Timestamp endTimestamp;

    private String ipAddress;

    public SessionDto(Long sessionNumber, Timestamp startTimestamp) {
        this.sessionNumber = sessionNumber;
        this.startTimestamp = startTimestamp;
    }

    public SessionDto(Long sessionNumber, Date startTimestamp) {
        this.sessionNumber = sessionNumber;
        this.startTimestamp = new Timestamp(startTimestamp.getTime());
    }

    public SessionDto(String actorIdentifier, long sessionNumber, Timestamp startTimestamp, Timestamp endTimestamp) {
        this.actorIdentifier = actorIdentifier;
        this.sessionNumber = sessionNumber;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return sqlType;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        sqlType = typeName;
        actorIdentifier = stream.readNString();
        sessionNumber = stream.readLong();
        startTimestamp = stream.readTimestamp();
        endTimestamp = stream.readTimestamp();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeNString(actorIdentifier);
        stream.writeLong(sessionNumber);
        stream.writeTimestamp(startTimestamp);
        stream.writeTimestamp(endTimestamp);
    }

}
