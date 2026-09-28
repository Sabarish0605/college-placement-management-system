package com.sabarish.placement_management_system.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Students {
    @Id
    private String registerNumber;
    private String name;
    private float cgpa;
}
