package com.sabarish.placement_management_system.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Students")
public class Student {
    @Id
    private String registerNumber;
    private String name;
    private float cgpa;
}
