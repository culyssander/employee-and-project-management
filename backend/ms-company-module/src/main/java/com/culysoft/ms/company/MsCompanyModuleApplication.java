package com.culysoft.ms.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableWebFlux
public class MsCompanyModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCompanyModuleApplication.class, args);
	}

}
