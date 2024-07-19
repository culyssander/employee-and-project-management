package com.culysoft.usermodule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleDto {

    private String id;

    @NotBlank
    private String name;
}
