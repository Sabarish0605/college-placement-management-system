package com.sabarish.placement_management_system;

import com.sabarish.placement_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sabarish.placement_management_system.Models.Students;

@RestController
public class PlacementController {
    @Autowired
    private  StudentService studentService;

    @GetMapping("/hello")
    ResponseEntity<String> getHello(){
        String str = "Hello Spring Boot";
        return new ResponseEntity<>(str, HttpStatus.OK);
    }
    @GetMapping("/students")
    ResponseEntity<String> getStudents() {
        String result = studentService.getStudents();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/student/{registerNumber}")
    ResponseEntity<String> getStudentByRegNo(
            @PathVariable String registerNumber) {

        String result =
                studentService.getStudentByRegNo(registerNumber);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/students", params = "department")
    ResponseEntity<String> getStudentsByDepartment(
            @RequestParam String department) {

        String result =
                studentService.getStudentsByDepartment(department);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/students")
    ResponseEntity<Students> createStudent(
            @RequestBody Students student) {

        Students result = studentService.createStudent(student);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/students/{registerNumber}")
    ResponseEntity<Students> updateStudent(
            @PathVariable String registerNumber,
            @RequestBody Students student) {

        Students result =
                studentService.updateStudent(registerNumber, student);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/students/{registerNumber}")
    ResponseEntity<String> deleteStudent(
            @PathVariable String registerNumber) {

        String result =
                studentService.deleteStudent(registerNumber);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
