package com.culysoft.ms.company.models.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class CompanyInput {

    @NotBlank
    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private boolean status;
    private String zip;
    private String notes;
    private String about;
    private boolean isCompanyClient;
}
