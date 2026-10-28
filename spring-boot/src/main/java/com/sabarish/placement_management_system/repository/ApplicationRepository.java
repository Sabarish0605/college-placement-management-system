package com.sabarish.placement_management_system.repository;

import com.sabarish.placement_management_system.Models.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository
        extends JpaRepository<Application, String> {

    List<Application> findByStudent_RegisterNumber(String registerNumber);

    List<Application> findByJob_JobId(String jobId);
}