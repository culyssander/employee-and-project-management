package com.culysoft.ms.company.models.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CompanyRegister {
    @NotBlank
    private String name;
}
