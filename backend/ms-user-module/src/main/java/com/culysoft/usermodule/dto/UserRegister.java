package com.culysoft.usermodule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRegister {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String companyName;
}
