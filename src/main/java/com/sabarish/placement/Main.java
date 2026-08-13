package com.sabarish.placement;

import com.sabarish.placement.model.Student;
import com.sabarish.placement.model.Company;
import com.sabarish.placement.model.Job;
import com.sabarish.placement.model.Application;
import com.sabarish.placement.service.PlacementService;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("DSA");
        skills.add("Communication");

        Student std1 = new Student("732123104091", "Sabarish M", "732123104091@nandhatech.org", "9965569808", "MALE", "CSE", 7.72, 0, skills, 2027);
//        Student std2 = new Student("732123104091", "Sabari", "732123104091@nandhatech.org", "9965569808", "MALE", "CSE", 7.72, 0, skills, 2027);
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
        System.out.println(std1.getGraduationYear());
        System.out.println(std1.getName());
        System.out.println(std1.getBacklogs());
        System.out.println(std1.getCgpa());
        System.out.println(std1.getContactNumber());
        System.out.println(std1.getDepartment());
        System.out.println(std1.getSkills());
        System.out.println(std1.getRegisterNumber());
        System.out.println(std1.getEmail());
        System.out.println(std1.getGender());
        std1.setCgpa(9.99);
        System.out.println(std1.getCgpa());
        // Skills updation
        List<String> updatedSkills = new ArrayList<>();

        updatedSkills.add("Java");
        updatedSkills.add("DSA");
        updatedSkills.add("Spring Boot");
        updatedSkills.add("testskill");

        std1.setSkills(updatedSkills);

        System.out.println(std1.getSkills());

//        company object creation and declaration

        Company company = new Company(
                "COMP001",
                "Zoho",
                "hr@zoho.com",
                "Software",
                "Chennai"
        );

        System.out.println(company.getName());
        System.out.println(company.getIndustry());


//        job object creation and declaration

        Job job = new Job(
                "JOB001",
                "Software Developer",
                "Backend development role",
                7.0,
                0,

//                here we use the company oject directly which created with Company class
//                it has all the properties of company inside so we directly add all the company details into job
                company
        );

        System.out.println(job.getRole());
        System.out.println(job.getCompany().getName());
        System.out.println(job.getMinimumCgpa());

//        Now application object is created by give job object and student object as a direct input

        Application application = new Application(
                "APP001",
                std1,
                job,
                "Applied"
        );

        System.out.println(application.getApplicationId());
        System.out.println(application.getStudent().getName());
        System.out.println(application.getJob().getRole());
        System.out.println(application.getStatus());

        PlacementService service = new PlacementService();
        service.addStudent(std1);
        service.addStudent(std2);
        System.out.println(service.getAllStudents());

        Student foundStudent = service.findStudentByRegisterNumber("732123104092");
        System.out.println(foundStudent);

//    Adding all the objects into the services
        service.addCompany(company);
        service.addJob(job);
        service.addApplication(application);


//        printing all the objects using the service officer

        System.out.println(service.getAllCompanies());
        System.out.println(service.getAllJobs());
        System.out.println(service.getAllApplications());
        System.out.println(service.isEligible(std1,job));
        service.applyForJob(std1,job);
        service.applyForJob(std2,job);
        System.out.println(service.getAllApplications());
    }
}
