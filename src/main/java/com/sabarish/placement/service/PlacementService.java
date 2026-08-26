package com.sabarish.placement.service;

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

    private List<Application> applications = new ArrayList<>();

    public PlacementService(StudentDAO studentDAO,
                            CompanyDAO companyDAO,
                            JobDAO jobDAO) {

        this.studentDAO = studentDAO;
        this.companyDAO = companyDAO;
        this.jobDAO = jobDAO;
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
        applications.add(application);
    }

    public List<Application> getAllApplications() {
        return applications;
    }

    // ==================== PLACEMENT LOGIC ====================

    public boolean isEligible(Student student, Job job) {

        if (student.getCgpa() < job.getMinimumCgpa()
                || student.getBacklogs() > job.getMaximumBacklogs()) {

            return false;
        }

        return true;
    }

    public boolean hasAlreadyApplied(Student student, Job job) {

        for (Application application : applications) {

            if (application.getJob().getJobId().equals(job.getJobId())
                    && application.getStudent().getRegisterNumber()
                    .equals(student.getRegisterNumber())) {

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

        int n = applications.size();

        String uniqueId = "APP" + String.format("%03d", n + 1);

        Application application = new Application(
                uniqueId,
                student,
                job,
                "Applied"
        );

        applications.add(application);

        System.out.println("Successfully applied");
    }

    public List<Job> getEligibleJobs(Student student) {

        List<Job> eligibleJobs = new ArrayList<>();

        for (Job job : jobDAO.findAll()) {

            if (isEligible(student, job)) {
                eligibleJobs.add(job);
            }
        }

        return eligibleJobs;
    }

    public List<Application> getApplicationsByStudent(Student student) {

        List<Application> appliedApplications = new ArrayList<>();

        for (Application application : applications) {

            if (application.getStudent()
                    .getRegisterNumber()
                    .equals(student.getRegisterNumber())) {

                appliedApplications.add(application);
            }
        }

        return appliedApplications;
    }
}