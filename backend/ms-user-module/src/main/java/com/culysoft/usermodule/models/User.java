package com.culysoft.usermodule.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Table(name = "USER_TB")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String email;
    private String password;
    private boolean status;

    @OneToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @Column(name = "deleted_at")
    private OffsetDateTime deletedAt;

    @Column(name = "company_id", nullable = false)
    private String companyId;
}
