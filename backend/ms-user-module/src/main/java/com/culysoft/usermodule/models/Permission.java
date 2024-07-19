package com.culysoft.usermodule.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Table(name = "PERMISSION_TB")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String description;
    @Column(name = "company_id", nullable = false)
    private String companyId;
}
