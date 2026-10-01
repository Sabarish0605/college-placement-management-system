package com.sabarish.placement_management_system.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Company {

    @Id
    private String companyId;

    private String name;
    private String email;
    private String industry;
    private String location;
}