package com.example.demo.dto;

import com.example.demo.entity.FlexiCaputreStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormResponse {

    private List<FlexiCaputreStatus> tableData;

}




