package com.culysoft.ms.company.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Problema {
    private Integer status;
    private OffsetDateTime dataHora;
    private String titulo;
    private List<Campo> campos;
}
