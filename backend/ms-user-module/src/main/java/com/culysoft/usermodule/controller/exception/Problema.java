package com.culysoft.usermodule.controller.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Problema {
    private Integer status;
    private OffsetDateTime dataHora;
    private String titulo;
    private List<Campo> campos;
}
