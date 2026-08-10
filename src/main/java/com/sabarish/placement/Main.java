package com.sabarish.placement;

import com.sabarish.placement.model.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("DSA");
        skills.add("Communication");

        Student std1 = new Student("732123104091", "Sabarish M", "732123104091@nandhatech.org", "9965569808", "MALE", "CSE", 7.72, 0, skills, 2027);
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
    }
}
