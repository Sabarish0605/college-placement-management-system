package com.sabarish.placement.model;

public class Job {

    private String jobId;
    private String role;
    private String description;
    private double minimumCgpa;
    private int maximumBacklogs;
    private Company company;

    public Job(String jobId, String role, String description,
               double minimumCgpa, int maximumBacklogs, Company company) {

        this.jobId = jobId;
        this.role = role;
        this.description = description;
        this.minimumCgpa = minimumCgpa;
        this.maximumBacklogs = maximumBacklogs;
        this.company = company;
    }

    public String getJobId() {
        return jobId;
    }

    public String getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }

    public double getMinimumCgpa() {
        return minimumCgpa;
    }

    public int getMaximumBacklogs() {
        return maximumBacklogs;
    }

    public Company getCompany() {
        return company;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMinimumCgpa(double minimumCgpa) {
        this.minimumCgpa = minimumCgpa;
    }

    public void setMaximumBacklogs(int maximumBacklogs) {
        this.maximumBacklogs = maximumBacklogs;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}