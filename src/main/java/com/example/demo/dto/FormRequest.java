package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormRequest {

    @NotBlank
    private String invoiceNumber;

    @NotBlank
    private String supplierNumber;

    private String customerNumber;

    private String amount;
}




