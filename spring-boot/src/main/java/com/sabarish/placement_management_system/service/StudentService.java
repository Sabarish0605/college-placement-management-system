package com.sabarish.placement_management_system.service;

import com.sabarish.placement_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sabarish.placement_management_system.Models.Student;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentByRegNo(String registerNumber){
        return studentRepository.findById(registerNumber).orElse(null);
    }

    public String getStudentsByDepartment(String department) {
        return "Students from department: " + department;
    }

    public Student createStudent(Student student) {

        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(String registerNumber) {

        studentRepository.deleteById(registerNumber);
    }
}
