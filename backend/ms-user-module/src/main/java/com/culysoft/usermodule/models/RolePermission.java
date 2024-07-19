package com.culysoft.usermodule.models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "role_permission_tb")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@IdClass(RolePermissionId.class)
public class RolePermission {

    @Id
    private String roleId;

    @Id
    private String permissionId;

    @Column(name = "company_id", nullable = false)
    private String companyId;
}
