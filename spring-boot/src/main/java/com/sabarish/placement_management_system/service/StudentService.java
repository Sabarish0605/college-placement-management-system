package com.sabarish.placement_management_system.service;

import com.sabarish.placement_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sabarish.placement_management_system.Models.Students;
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String getStudents(){
        return "allStudents";
    }

    public String getStudentByRegNo(String registerNumber){
        return "Student with "+ registerNumber;
    }

    public String getStudentsByDepartment(String department) {
        return "Students from department: " + department;
    }

    public Students createStudent(Students student) {

        return studentRepository.save(student);
    }

    public Students updateStudent(String registerNumber, Students student) {
        return student;
    }

    public String deleteStudent(String registerNumber) {
        return "The student with " + registerNumber + " is deleted";
    }
}
