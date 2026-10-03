package com.sabarish.placement_management_system.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "application")
@Data
public class Application {

    @Id
    private String applicationId;

    private String studentRegisterNumber;
    private String jobId;
    private String status;
}