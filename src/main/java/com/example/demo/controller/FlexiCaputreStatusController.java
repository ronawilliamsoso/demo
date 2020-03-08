package com.example.demo.controller;


import com.example.demo.dto.FormRequest;
import com.example.demo.dto.FormResponse;
import com.example.demo.entity.FlexiCaptureStatusPk;
import com.example.demo.entity.FlexiCaputreStatus;
import com.example.demo.repository.FlexiCaputreStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FlexiCaputreStatusController {

    private final FlexiCaputreStatusRepository flexiCaputreStatusRepository;

    @GetMapping(path = "/flexiCaputreStatus/findAll")
    public List<FlexiCaputreStatus> getInvoiceData() {

        List<FlexiCaputreStatus> temp = flexiCaputreStatusRepository.findAll();

        return temp;

    }

    @PostMapping(value = "/flexiCaputreStatus/search"
                    )//,consumes = MediaType.APPLICATION_JSON_VALUE
                   // ,produces = MediaType.APPLICATION_JSON_VALUE
    public FlexiCaputreStatus search( @Valid @RequestBody FormRequest formRequest) {

        FlexiCaputreStatus temp = flexiCaputreStatusRepository.findById(FlexiCaptureStatusPk.builder()
                                                                                            .invoiceId(formRequest.getInvoiceNumber())
                                                                                            .supplierId(formRequest.getSupplierNumber())
                                                                                            .build())
                                                              .orElse(FlexiCaputreStatus.builder()
                                                                                        .build());
        System.out.println("My temp: " + temp);
        return temp;
    }

    @GetMapping(value = "/flexiCaputreStatus/test"
    )//,consumes = MediaType.APPLICATION_JSON_VALUE
    // ,produces = MediaType.APPLICATION_JSON_VALUE
    public FormResponse searchTest( @Valid FormRequest formRequest) {

        return FormResponse.builder().tableData( List.of( flexiCaputreStatusRepository.findById(FlexiCaptureStatusPk.builder()
                .invoiceId(formRequest.getInvoiceNumber())
                .supplierId(formRequest.getSupplierNumber())
                .build())
                .orElse(FlexiCaputreStatus.builder()
                        .build()))).build();

    }

}
