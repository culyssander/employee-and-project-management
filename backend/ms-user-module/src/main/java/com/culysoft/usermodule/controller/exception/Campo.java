package com.culysoft.usermodule.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Campo {
    private String nome;
    private String mensagem;
}
