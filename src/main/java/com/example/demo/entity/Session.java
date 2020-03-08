package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


//@SqlResultSetMapping(name = "SessionDtoResultSet",
//        classes = {@ConstructorResult(targetClass = SessionDto.class,
//                columns = {@ColumnResult(name = "sessionNumber", type = Long.class),
//                        @ColumnResult(name = "startTimestamp", type = Date.class)})})
//@NamedNativeQueries({
//        @NamedNativeQuery(name = Session.CREATE_SESSION,
//                query = "select o_session_number as sessionNumber, o_start_time as startTimestamp from create_session(?, ?)",
//                resultSetMapping = "SessionDtoResultSet"),
//        @NamedNativeQuery(name = Session.CREATE_SESSION_END, query = "select create_session_end(?, ?)"), @NamedNativeQuery(
//        name = Session.CREATE_UNIFIED_SESSION, query = "select create_unverified_session(?, ?, ?, ?, ?, ?, ?, ?, ?)")})
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Session implements Serializable {

    @Id
    private Long id;

    private String registrant; // todo:no actor?
    private String orderReference;
    private String customerUid;
    private String datetime;
    private String ipAddress;

}