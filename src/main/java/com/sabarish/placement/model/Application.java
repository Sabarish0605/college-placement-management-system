package com.sabarish.placement.model;

public class Application {

    private String applicationId;
    private Student student;
    private Job job;
    private String status;

    public Application(String applicationId, Student student,
                       Job job, String status) {

        this.applicationId = applicationId;
        this.student = student;
        this.job = job;
        this.status = status;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public Student getStudent() {
        return student;
    }

    public Job getJob() {
        return job;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Application{" +
                "applicationId='" + applicationId + '\'' +
                ", student=" + student +
                ", job=" + job +
                ", status='" + status + '\'' +
                '}';
    }
}