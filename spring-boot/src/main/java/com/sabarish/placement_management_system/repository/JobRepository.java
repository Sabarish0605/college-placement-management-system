package com.sabarish.placement_management_system.repository;

import com.sabarish.placement_management_system.Models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, String> {

    List<Job> findByCompany_CompanyId(String companyId);
}