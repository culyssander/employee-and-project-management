package com.culysoft.ms.company.repository;

import com.culysoft.ms.company.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

    Optional<Company> findByName(String name);
    Optional<Company> findByIdAndName(String Id, String name);

    boolean existsByName(String nome);

}
