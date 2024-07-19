package com.culysoft.usermodule.client;

import com.culysoft.usermodule.dto.client.CompanyOutput;
import com.culysoft.usermodule.dto.client.CompanyRegister;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ms-company-integration", url = "${ms.company.integration.host}")
public interface CompanyFeignClient {

    @GetMapping("/name/{name}")
    public CompanyOutput findByName(@PathVariable String name);

    @PostMapping
    public CompanyOutput registry(@Validated @RequestBody CompanyRegister companyRegister,
                                  @RequestHeader String createdBy);
}
