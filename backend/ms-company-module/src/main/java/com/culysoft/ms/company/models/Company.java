package com.culysoft.ms.company.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Table(name = "COMPANY_TB")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_AT")
    private OffsetDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private OffsetDateTime updatedAt;

    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private boolean status;
    private String zip;
    private String notes;
    private String about;
}
