package com.sabarish.placement.service;

import com.sabarish.placement.dao.ApplicationDAO;
import com.sabarish.placement.dao.CompanyDAO;
import com.sabarish.placement.dao.JobDAO;
import com.sabarish.placement.dao.StudentDAO;
import com.sabarish.placement.exception.AllreadyAppliedException;
import com.sabarish.placement.exception.NotEligibleException;
import com.sabarish.placement.model.Application;
import com.sabarish.placement.model.Company;
import com.sabarish.placement.model.Job;
import com.sabarish.placement.model.Student;

import java.util.ArrayList;
import java.util.List;

public class PlacementService {

    private StudentDAO studentDAO;
    private CompanyDAO companyDAO;
    private JobDAO jobDAO;
    private ApplicationDAO applicationDAO;


    public PlacementService(StudentDAO studentDAO,
                            CompanyDAO companyDAO,
                            JobDAO jobDAO,
                            ApplicationDAO applicationDAO) {

        this.studentDAO = studentDAO;
        this.companyDAO = companyDAO;
        this.jobDAO = jobDAO;
        this.applicationDAO = applicationDAO;
    }


    // ==================== STUDENT ====================

    public void addStudent(Student student) {
        studentDAO.save(student);
    }

    public Student findStudentByRegisterNumber(String regNo) {
        return studentDAO.findByRegisterNumber(regNo);
    }

    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }


    // ==================== COMPANY ====================

    public void addCompany(Company company) {
        companyDAO.save(company);
    }

    public Company findCompanyById(String companyId) {
        return companyDAO.findByCompanyId(companyId);
    }

    public List<Company> getAllCompanies() {
        return companyDAO.findAll();
    }


    // ==================== JOB ====================

    public void addJob(Job job) {
        jobDAO.save(job);
    }

    public Job findJobById(String jobId) {
        return jobDAO.findByJobId(jobId);
    }

    public List<Job> getAllJobs() {
        return jobDAO.findAll();
    }


    // ==================== APPLICATION ====================

    public void addApplication(Application application) {
        applicationDAO.save(application);
    }

    public Application findApplicationById(String applicationId) {
        return applicationDAO.findByApplicationId(applicationId);
    }

    public List<Application> getAllApplications() {
        return applicationDAO.findAll();
    }


    // ==================== PLACEMENT LOGIC ====================

    public boolean isEligible(Student student, Job job) {

        return student.getCgpa() >= job.getMinimumCgpa()
                && student.getBacklogs() <= job.getMaximumBacklogs();
    }


    public boolean hasAlreadyApplied(Student student, Job job) {

        List<Application> applications =
                applicationDAO.findByStudentRegisterNumber(
                        student.getRegisterNumber()
                );

        for (Application application : applications) {

            if (application.getJob()
                    .getJobId()
                    .equals(job.getJobId())) {

                return true;
            }
        }

        return false;
    }


    public void applyForJob(Student student, Job job)
            throws AllreadyAppliedException, NotEligibleException {

        if (hasAlreadyApplied(student, job)) {

            throw new AllreadyAppliedException(
                    "This candidate already applied to this job"
            );
        }


        if (!isEligible(student, job)) {

            throw new NotEligibleException(
                    "This candidate is not eligible for this job"
            );
        }


        int count = applicationDAO.findAll().size();

        String applicationId =
                "APP" + String.format("%03d", count + 1);


        Application application = new Application(
                applicationId,
                student,
                job,
                "Applied"
        );


        applicationDAO.save(application);

        System.out.println("Successfully applied");
    }


    // ==================== ELIGIBLE JOBS ====================

    public List<Job> getEligibleJobs(Student student) {

        List<Job> eligibleJobs = new ArrayList<>();

        for (Job job : jobDAO.findAll()) {

            if (isEligible(student, job)) {
                eligibleJobs.add(job);
            }
        }

        return eligibleJobs;
    }


    // ==================== STUDENT APPLICATIONS ====================

    public List<Application> getApplicationsByStudent(Student student) {

        return applicationDAO.findByStudentRegisterNumber(
                student.getRegisterNumber()
        );
    }
}