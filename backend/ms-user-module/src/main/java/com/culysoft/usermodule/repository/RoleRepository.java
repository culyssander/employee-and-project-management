package com.culysoft.usermodule.repository;

import com.culysoft.usermodule.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    List<Role> findByCompanyId(String companyId);

    Optional<Role> findByNameAndCompanyId(String name, String companyId);
}
