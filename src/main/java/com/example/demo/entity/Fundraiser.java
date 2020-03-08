package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Fundraiser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String code;

    private String name;

    @Column(name = "PARTICIPANT_REGISTER")
    private String participantRegister;

    public static Fundraiser with(String fundraiserCode) {
        return new Fundraiser(fundraiserCode);
    }

    public Fundraiser(String fundraiserCode) {
        code = fundraiserCode;
    }

    @Override
    public String toString() {
        return String.format("Fundraiser [code=%s, name=%s, participantRegister=%s]", code, name, participantRegister);
    }

}