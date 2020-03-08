package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Subscription implements Serializable {



    @EmbeddedId
    private SubscriptionRequestPK id;

    @Column(name = "CONTACT_POINT")
    private String contactPoint;

    private String fundraiser;

    private String medium;

    private String stream;


//    @ManyToOne
//    @JoinColumns({
//        @JoinColumn(name = "FUNDRAISER", referencedColumnName = "FUNDRAISER", insertable = false, updatable = false),
//        @JoinColumn(name = "MEDIUM", referencedColumnName = "MEDIUM", insertable = false, updatable = false),
//        @JoinColumn(name = "STREAM", referencedColumnName = "name", insertable = false, updatable = false)})
//    private Stream streamTuple;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "MEDIUM", referencedColumnName = "code", insertable = false, updatable = false)})
    private Medium mediumTuple;

}