package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author wangwei
 */
@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubscriptionRequestPK implements Serializable {

    private static final long serialVersionUID = 1L;

    private String actor;

    @Column(name = "SESSION_")
    private long session;

    @Column(name = "TRANSACTION_")
    private long transaction;

}