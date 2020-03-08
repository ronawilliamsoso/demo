package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table
@IdClass( FlexiCaptureStatusPk.class )
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlexiCaputreStatus {
    @Id
    private String supplierId;

    @Id
    private String invoiceId;

    private String city;

    private String url;

    private String pdfPath;

}
