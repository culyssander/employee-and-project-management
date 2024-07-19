package com.culysoft.usermodule.repository;

import com.culysoft.usermodule.models.RolePermission;
import com.culysoft.usermodule.models.RolePermissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, RolePermissionId> {
}
