package com.culysoft.ms.company.service;

import com.culysoft.ms.company.exception.CompanyBadRequestException;
import com.culysoft.ms.company.exception.CompanyNotFoundException;
import com.culysoft.ms.company.exception.CompanySaveException;
import com.culysoft.ms.company.models.Company;
import com.culysoft.ms.company.models.dto.CompanyInput;
import com.culysoft.ms.company.models.dto.CompanyOutput;
import com.culysoft.ms.company.models.dto.CompanyRegister;
import com.culysoft.ms.company.repository.CompanyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CompanyService {

    private CompanyRepository companyRepository;
    private ModelMapper modelMapper;

    public CompanyOutput findByName(String name) {
        return modelMapper.map(companyRepository.findByName(name)
                .orElseThrow(CompanyNotFoundException::new), CompanyOutput.class);
    }

    public Company findById(String id) {
        return companyRepository.findById(id)
                .orElseThrow(CompanyNotFoundException::new);
    }

    public Company findByIdAndName(String id, String name) {
        return companyRepository.findByIdAndName(id, name)
                .orElseThrow(CompanyNotFoundException::new);
    }

    public CompanyOutput register(CompanyRegister register, String createdBy) {
        try {
            if (companyRepository.existsByName(register.getName()))
                throw new CompanyBadRequestException("Company already exists");

            Company company = Company.builder()
                    .id(UUID.randomUUID().toString())
                    .name(register.getName())
                    .status(true)
                    .createdAt(OffsetDateTime.now())
                    .createdBy(createdBy)
                    .build();

             return modelMapper.map(companyRepository.save(company), CompanyOutput.class);
        } catch (CompanySaveException e) {
            throw new CompanySaveException(e.getMessage());
        }
    }

    public CompanyOutput update(String id, String input, File file) {
        try {
            CompanyInput companyInput = convertJsonToObject(input);
            Company companyTemp = findById(id);

            companyTemp.setUpdatedAt(OffsetDateTime.now());
            companyTemp.setAbout(companyInput.getAbout());
            companyTemp.setCity(companyInput.getCity());
            companyTemp.setAddress(companyInput.getAddress());
            companyTemp.setName(companyInput.getName());
            companyTemp.setImageUrl(imageUrl(file));
            companyTemp.setEmail(companyInput.getEmail());
            companyTemp.setNotes(companyInput.getNotes());
            companyTemp.setZip(companyInput.getZip());
            companyTemp.setStatus(companyInput.isStatus());
            companyTemp.setPhone(companyInput.getPhone());

            return modelMapper.map(companyRepository.save(companyTemp), CompanyOutput.class);
        } catch (CompanySaveException e) {
            throw new CompanySaveException(e.getMessage());
        }
    }

    private CompanyInput convertJsonToObject(String input) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(input, CompanyInput.class);
        } catch (IOException e) {
            throw new CompanyBadRequestException("Invalid json: " + e.getMessage());
        }
    }

    private String imageUrl(File file) {
        // S3 ou Google Cloud to store image
        return null;
    }
}
