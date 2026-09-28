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
    ResponseEntity<String> getStudents(){
//        String str = "return all students";
        return new ResponseEntity<>(studentService.getStudents(),HttpStatus.OK);
    }
    @GetMapping("/student/{registerNumber}")
    ResponseEntity<String> getStudentByRegNo(@PathVariable String registerNumber){
        return new ResponseEntity<>(studentService.getStudentByRegNo(registerNumber),HttpStatus.OK);
    }
    @GetMapping(value = "/students",params = "dept")
    ResponseEntity<String> getStudentByDept(@RequestParam String dept){
        String str = "Student of "+dept;
        return new ResponseEntity<>(str,HttpStatus.OK);
    }


    @PostMapping("/students")
    ResponseEntity<Students> createStudent(@RequestBody Students students){
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @PutMapping("/students/{registerNumber}")
    ResponseEntity<Students> updateStudent(@RequestBody Students students, @PathVariable String registerNumber){

        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @DeleteMapping("/students/{registerNumber}")
    ResponseEntity<String> deleteStudent(@PathVariable String registerNumber){
        String str = "The student with "+registerNumber+" is deleted";
        return new ResponseEntity<>(str,HttpStatus.OK);
    }




}
