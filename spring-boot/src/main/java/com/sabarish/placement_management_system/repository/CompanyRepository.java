package com.sabarish.placement_management_system.repository;

import com.sabarish.placement_management_system.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}