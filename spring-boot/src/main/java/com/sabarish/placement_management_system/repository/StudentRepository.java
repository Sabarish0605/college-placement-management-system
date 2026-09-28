package com.sabarish.placement_management_system.repository;

import com.sabarish.placement_management_system.Models.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students,String> {

}
