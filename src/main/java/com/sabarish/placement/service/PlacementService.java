package com.sabarish.placement.service;
import com.sabarish.placement.exception.AllreadyAppliedException;
import com.sabarish.placement.exception.NotEligibleException;
import com.sabarish.placement.model.Application;
import com.sabarish.placement.model.Company;
import com.sabarish.placement.model.Job;
import java.util.ArrayList;
import com.sabarish.placement.model.Student;
import com.sabarish.placement.dao.StudentDAO;
import java.util.List;
public class PlacementService {
    private StudentDAO studentDAO;
    private List<Company> companies = new ArrayList<>();
    private List<Job> jobs = new ArrayList<>();
    private List<Application> applications = new ArrayList<>();

//    Constructor for the sudentdao
    public PlacementService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
//    Adding the objects as a data type of arraylist
    public void addStudent(Student student){
        studentDAO.save(student);
    }

    public Student findStudentByRegisterNumber(String regNo) {
        return studentDAO.findByRegisterNumber(regNo);
    }

    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }
    public void addCompany(Company company) {
        companies.add(company);
    }

    public void addJob(Job job) {
        jobs.add(job);
    }

    public void addApplication(Application application) {
        applications.add(application);
    }

    public List<Company> getAllCompanies() {
        return companies;
    }

    public List<Job> getAllJobs() {
        return jobs;
    }

    public List<Application> getAllApplications() {
        return applications;
    }

    public boolean isEligible(Student student,Job job){
        if(student.getCgpa() < job.getMinimumCgpa() || student.getBacklogs() > job.getMaximumBacklogs()){
            return false;
        }else{
            return true;
        }
    }

    public boolean hasAlreadyApplied(Student student,Job job){
        for(Application application : applications){
            if(application.getJob().getJobId().equals(job.getJobId()) && application.getStudent().getRegisterNumber().equals(student.getRegisterNumber())){
                return true;
            }
        }
        return false;
    }

    public void applyForJob(Student student, Job job) throws AllreadyAppliedException, NotEligibleException {

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
        for (Job job : jobs) {
            if(isEligible(student,job)){
                eligibleJobs.add(job);
            }
        }
        return eligibleJobs;
    }

    public List<Application> getApplicationsByStudent(Student student) {
        List<Application> appliedApplications = new ArrayList<>();
        for(Application application : applications){
            if(application.getStudent().getRegisterNumber().equals(student.getRegisterNumber())){
                appliedApplications.add(application);
            }
        }
        return appliedApplications;
    }



}