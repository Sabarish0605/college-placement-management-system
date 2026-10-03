package com.sabarish.placement_management_system.service;

import com.sabarish.placement_management_system.Models.Job;
import com.sabarish.placement_management_system.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJobById(String jobId) {
        return jobRepository.findById(jobId).orElse(null);
    }

    public List<Job> getJobsByCompany(String companyId) {
        return jobRepository.findByCompany_CompanyId(companyId);
    }
    public Job updateJob(String jobId, Job job) {
        return jobRepository.save(job);
    }

    public void deleteJob(String jobId) {
        jobRepository.deleteById(jobId);
    }
}