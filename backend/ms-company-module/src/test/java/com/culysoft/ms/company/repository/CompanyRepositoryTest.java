package com.culysoft.ms.company.repository;

import com.culysoft.ms.company.models.Company;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;
    private final String COMPANY_NAME = "CULYSOFT";
    private final String COMPANY_ID = "7a968a7e-839a-4e49-b159-c55554476c74";

    @Test
    void should_return_true_when_findByName() {
        // given
        companyRepository.save(createCompany());

        // when
        Optional<Company> companyFound = companyRepository.findByName(COMPANY_NAME);

        // then
        Assertions.assertTrue(companyFound.isPresent());
    }

    @Test
    void should_return_false_when_findByName() {
        // given
        // when
        Optional<Company> companyFound = companyRepository.findByName(COMPANY_NAME);

        // then
        Assertions.assertFalse(companyFound.isPresent());
    }

    @Test
    void should_return_true_when_findByIdAndName() {
        // given
        companyRepository.save(createCompany());

        // when
        Optional<Company> companyFound = companyRepository.findByIdAndName(COMPANY_ID, COMPANY_NAME);

        // then
        Assertions.assertTrue(companyFound.isPresent());
    }

    @Test
    void should_return_false_when_findByIdAndName() {
        // given
        // when
        Optional<Company> companyFound = companyRepository.findByIdAndName(COMPANY_ID, COMPANY_NAME);

        // then
        Assertions.assertFalse(companyFound.isPresent());
    }

    @Test
    void should_return_true_when_existsByName() {
        // given
        companyRepository.save(createCompany());

        // when
        boolean result = companyRepository.existsByName(COMPANY_NAME);

        // then
        Assertions.assertTrue(result);
    }

    @Test
    void should_return_false_when_existsByName() {
        // given
        // when
        boolean result  = companyRepository.existsByName(COMPANY_NAME);

        // then
        Assertions.assertFalse(result);
    }

    private Company createCompany() {
        return Company.builder()
                .id(COMPANY_ID)
                .name(COMPANY_NAME)
                .createdBy("TEST")
                .createdAt(OffsetDateTime.now())
                .build();
    }
}