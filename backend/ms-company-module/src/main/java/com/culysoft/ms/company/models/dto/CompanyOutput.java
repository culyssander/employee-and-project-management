package com.culysoft.ms.company.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyOutput {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private boolean status;
    private String zip;
    private String notes;
    private String about;
    private String imageUrl;
    private String createdBy;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
