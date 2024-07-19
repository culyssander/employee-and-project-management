package com.culysoft.usermodule.repository;

import com.culysoft.usermodule.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, String> {
}
