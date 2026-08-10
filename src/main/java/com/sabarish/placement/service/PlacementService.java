package com.sabarish.placement.service;
import com.sabarish.placement.model.Application;
import com.sabarish.placement.model.Company;
import com.sabarish.placement.model.Job;
import java.util.ArrayList;
import com.sabarish.placement.model.Student;
import java.util.List;
public class PlacementService {
    private List<Student> students = new ArrayList<>();
    private List<Company> companies = new ArrayList<>();
    private List<Job> jobs = new ArrayList<>();
    private List<Application> applications = new ArrayList<>();

//    Adding the objects as a data type of arraylist
    public void addStudent(Student student){
        students.add(student);
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



//    Adding the getters for the objects from the arrayList

    public List<Student> getAllStudents(){
        return students;
    }


    public Student findStudentByRegisterNumber(String RegNo){
        for(Student stud : students){
            if(stud.getRegisterNumber().equals(RegNo)){
                return stud;
            }
        }
        return null;
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



}