package com.sabarish.placement_management_system.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Students")
@Data
public class Student {

    @Id
    private String registerNumber;

    private String name;

    private float cgpa;

    @OneToMany(mappedBy = "student")
    private List<Application> applications;
}