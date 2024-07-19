package com.culysoft.ms.company.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CompanyNotFoundException extends RuntimeException {

    public CompanyNotFoundException(String message) {
        super(message);
    }
}
