package com.sabarish.placement.dao;

import com.sabarish.placement.model.Application;

import java.util.List;

public interface ApplicationDAO {

    void save(Application application);

    Application findByApplicationId(String applicationId);

    List<Application> findAll();

    List<Application> findByStudentRegisterNumber(String registerNumber);
}