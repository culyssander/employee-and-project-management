package com.culysoft.usermodule.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Table(name = "ROLE_TB")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;

    @Column(name = "company_id", nullable = false)
    private String companyId;
}
