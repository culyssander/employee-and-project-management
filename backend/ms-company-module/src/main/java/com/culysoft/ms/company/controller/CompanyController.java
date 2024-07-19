package com.culysoft.ms.company.controller;

import com.culysoft.ms.company.models.Company;
import com.culysoft.ms.company.models.dto.CompanyOutput;
import com.culysoft.ms.company.models.dto.CompanyRegister;
import com.culysoft.ms.company.service.CompanyService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@RequestMapping("/api/v1/companies")
@AllArgsConstructor
@Tag(name = "Company", description = "Company registration and search API. Start of the project to have a management environment.")
public class CompanyController {

    private CompanyService companyService;

    @GetMapping("/name/{name}")
    public CompanyOutput findByName(@PathVariable String name) {
        return companyService.findByName(name);
    }

    @GetMapping("/{id}")
    public Company findById(@PathVariable String id) {
        return companyService.findById(id);
    }

    @GetMapping("/{id}/name/{name}")
    public Company findById(@PathVariable String id, @PathVariable String name) {
        return companyService.findByIdAndName(id, name);
    }

    @PostMapping
    @Hidden
    public CompanyOutput registry(@Validated @RequestBody CompanyRegister companyRegister,
                                  @RequestHeader String createdBy) {
        return companyService.register(companyRegister, createdBy);
    }

    @PutMapping("/{id}")
    public CompanyOutput update(@PathVariable String id, String input, File file) {
        return companyService.update(id, input, file);
    }
}
