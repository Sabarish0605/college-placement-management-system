package com.sabarish.placement_management_system.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "company")
@Data
public class Company {

    @Id
    private String companyId;

    private String name;
    private String email;
    private String industry;
    private String location;

    @OneToMany(mappedBy = "company")
    private List<Job> jobs;
}