package com.culysoft.usermodule.repository;

import com.culysoft.usermodule.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByCompanyId(String companyId);
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
//    Optional<User> findByEmailAndCompany(String name, String company);
//    Optional<User> findByIdAndCompany(String id, String company);
//    Optional<User> findByNameAndCompany(String name, String company);
}
