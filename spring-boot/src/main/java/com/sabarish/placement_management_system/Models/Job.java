package com.sabarish.placement_management_system.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "job")
@Data
public class Job {

    @Id
    private String jobId;

    private String role;

    private String description;

    private double minimumCgpa;

    private int maximumBacklogs;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}