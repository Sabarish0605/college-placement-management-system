package com.sabarish.placement_management_system.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "application")
@Data
public class Application {

    @Id
    private String applicationId;

    private String status;

    @ManyToOne
    @JoinColumn(name = "student_register_number")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
}