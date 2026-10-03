package com.sabarish.placement_management_system.service;

import com.sabarish.placement_management_system.Models.Application;
import com.sabarish.placement_management_system.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Application getApplicationById(String applicationId) {
        return applicationRepository
                .findById(applicationId)
                .orElse(null);
    }

    public List<Application> getApplicationsByStudent(
            String studentRegisterNumber) {

        return applicationRepository
                .findByStudentRegisterNumber(studentRegisterNumber);
    }

    public List<Application> getApplicationsByJob(String jobId) {

        return applicationRepository.findByJobId(jobId);
    }

    public Application updateApplication(
            String applicationId,
            Application application) {

        return applicationRepository.save(application);
    }

    public void deleteApplication(String applicationId) {

        applicationRepository.deleteById(applicationId);
    }
}