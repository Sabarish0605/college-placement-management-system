package com.sabarish.placement.model;

import java.util.Arrays;
import java.util.List;

public class Student {
    private String registerNumber;
    private String name;
    private String email;
    private String contactNumber;
    private String gender;
    private String department;
    private double cgpa;
    private int backlogs;
    private List<String> skills;
    private int graduationYear;


     public Student(String registerNumber,String name,String email, String contactNumber, String gender, String department,double cgpa, int backlogs, List<String> skills, int graduationYear){
        this.registerNumber = registerNumber;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.gender = gender;
        this.department = department;
        this.cgpa = cgpa;
        this.backlogs = backlogs;
        this.skills  = skills;
        this.graduationYear = graduationYear;
    }

    public String getName(){
         return name;
    }
    public String getRegisterNumber(){
        return registerNumber;
    }
    public String getEmail(){
        return email;
    }
    public String getContactNumber(){
        return contactNumber;
    }
    public String getGender(){
        return gender;
    }
    public String getDepartment(){
        return department;
    }
    public double getCgpa(){
         return cgpa;
    }
    public int getBacklogs(){
         return backlogs;
    }
    public List<String> getSkills(){ return skills;}
    public int getGraduationYear(){
         return graduationYear;
    }
    public void setCgpa(double cgpa){ this.cgpa = cgpa;}
    public void setName(String name){ this.name = name;}
    public void setEmail(String email){ this.email = email;}
    public void setContactNumber(String contactNumber){ this.contactNumber = contactNumber;}
    public void setBacklogs(int backlogs){ this.backlogs = backlogs;}
    public void setSkills(List<String> skills){ this.skills = skills;}

    @Override
    public String toString() {
        return "Student{" +
                "registerNumber='" + registerNumber + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", cgpa=" + cgpa +
                ", backlogs=" + backlogs +
                ", skills=" + skills +
                ", graduationYear=" + graduationYear +
                '}';
    }
}