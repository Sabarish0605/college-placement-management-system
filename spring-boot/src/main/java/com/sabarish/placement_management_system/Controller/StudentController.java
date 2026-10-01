package com.sabarish.placement_management_system.Controller;

import com.sabarish.placement_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sabarish.placement_management_system.Models.Student;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private  StudentService studentService;

    @GetMapping("/hello")
    ResponseEntity<String> getHello(){
        String str = "Hello Spring Boot";
        return new ResponseEntity<>(str, HttpStatus.OK);
    }
    @GetMapping("/students")
    ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/student/{registerNumber}")
    ResponseEntity<Student> getStudentByRegNo(
            @PathVariable String registerNumber) {

        Student student = studentService.getStudentByRegNo(registerNumber);

        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping(value = "/students", params = "department")
    ResponseEntity<String> getStudentsByDepartment(
            @RequestParam String department) {

        String result =
                studentService.getStudentsByDepartment(department);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/students")
    ResponseEntity<Student> createStudent(
            @RequestBody Student student) {

        Student result = studentService.createStudent(student);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/students/{registerNumber}")
    ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.updateStudent(student), HttpStatus.OK);
    }

    @DeleteMapping("/students/{registerNumber}")
    ResponseEntity<String> deleteStudent(@PathVariable String registerNumber) {

        studentService.deleteStudent(registerNumber);
        return new ResponseEntity<>("Student successfully deleted", HttpStatus.OK);
    }
}
