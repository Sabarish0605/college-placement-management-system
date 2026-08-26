package com.sabarish.placement;

import com.sabarish.placement.dao.CompanyDAO;
import com.sabarish.placement.dao.CompanyDAOImpl;
import com.sabarish.placement.dao.JobDAO;
import com.sabarish.placement.dao.JobDAOImpl;
import com.sabarish.placement.dao.StudentDAO;
import com.sabarish.placement.dao.StudentDAOImpl;
import com.sabarish.placement.exception.AllreadyAppliedException;
import com.sabarish.placement.exception.NotEligibleException;
import com.sabarish.placement.model.Company;
import com.sabarish.placement.model.Job;
import com.sabarish.placement.model.Student;
import com.sabarish.placement.service.PlacementService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // ==================== STUDENTS ====================

        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("DSA");
        skills.add("Communication");

        Student std1 = new Student(
                "732123104091",
                "Sabarish M",
                "732123104091@nandhatech.org",
                "9965569808",
                "MALE",
                "CSE",
                7.72,
                0,
                skills,
                2027
        );

        Student std2 = new Student(
                "732123104092",
                "Arun Kumar",
                "arun@nandhatech.org",
                "9876543210",
                "MALE",
                "ECE",
                8.1,
                0,
                new ArrayList<>(List.of("Java", "Python")),
                2027
        );

        // ==================== COMPANY ====================

        Company company = new Company(
                "COMP001",
                "Zoho",
                "hr@zoho.com",
                "Software",
                "Chennai"
        );

        // ==================== JOBS ====================

        Job job = new Job(
                "JOB001",
                "Software Developer",
                "Backend development role",
                7.0,
                0,
                company
        );

        Job job2 = new Job(
                "JOB002",
                "Data Scientist",
                "Data science role",
                9.0,
                0,
                company
        );

        Job job3 = new Job(
                "JOB003",
                "Java Developer",
                "Java backend role",
                8.0,
                1,
                company
        );

        // ==================== DAO + SERVICE ====================

        StudentDAO studentDAO = new StudentDAOImpl();
        CompanyDAO companyDAO = new CompanyDAOImpl();
        JobDAO jobDAO = new JobDAOImpl();

        PlacementService service =
                new PlacementService(studentDAO, companyDAO, jobDAO);

        // ==================== ADD DATA ====================

        // Add only if these records are not already present in DB.
        // service.addStudent(std1);
        // service.addStudent(std2);

        // service.addCompany(company);

        // Add only if these records are not already present in DB.
//        service.addJob(job);
//        service.addJob(job2);
//        service.addJob(job3);

        // ==================== COMPANY TESTING ====================

        Company foundCompany = service.findCompanyById("COMP001");

        System.out.println("Found Company:");
        System.out.println(foundCompany);

        System.out.println("All Companies:");
        System.out.println(service.getAllCompanies());

        // ==================== JOB TESTING ====================

        Job foundJob = service.findJobById("JOB001");

        System.out.println("Found Job:");
        System.out.println(foundJob);

        System.out.println("All Jobs:");
        System.out.println(service.getAllJobs());

        // ==================== STUDENT TESTING ====================

        Student foundStudent =
                service.findStudentByRegisterNumber("732123104092");

        System.out.println("Found Student:");
        System.out.println(foundStudent);

        System.out.println("All Students:");
        System.out.println(service.getAllStudents());

        // ==================== APPLY FOR JOB ====================

        try {
            service.applyForJob(std1, job);
        } catch (AllreadyAppliedException e) {
            System.out.println(e.getMessage());
        } catch (NotEligibleException e) {
            System.out.println(e.getMessage());
        }

        try {
            service.applyForJob(std2, job);
        } catch (AllreadyAppliedException e) {
            System.out.println(e.getMessage());
        } catch (NotEligibleException e) {
            System.out.println(e.getMessage());
        }

        // ==================== VIEW APPLICATIONS ====================

        System.out.println("All Applications:");
        System.out.println(service.getAllApplications());

        // ==================== ELIGIBLE JOBS ====================

        System.out.println("Sabarish Eligible Jobs:");
        System.out.println(service.getEligibleJobs(std1));

        System.out.println("Arun Eligible Jobs:");
        System.out.println(service.getEligibleJobs(std2));

        // ==================== STUDENT APPLICATIONS ====================

        System.out.println("Sabarish Applications:");
        System.out.println(service.getApplicationsByStudent(std1));

        System.out.println("Arun Applications:");
        System.out.println(service.getApplicationsByStudent(std2));
    }
}