package com.sabarish.placement_management_system.Controller;

import com.sabarish.placement_management_system.Models.Application;
import com.sabarish.placement_management_system.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping
    ResponseEntity<Application> createApplication(
            @RequestBody Application application) {

        Application savedApplication =
                applicationService.createApplication(application);

        return new ResponseEntity<>(
                savedApplication,
                HttpStatus.CREATED
        );
    }

    @GetMapping
    ResponseEntity<List<Application>> getAllApplications() {

        return new ResponseEntity<>(
                applicationService.getAllApplications(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{applicationId}")
    ResponseEntity<Application> getApplicationById(
            @PathVariable String applicationId) {

        Application application =
                applicationService.getApplicationById(applicationId);

        if (application == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                application,
                HttpStatus.OK
        );
    }

    @GetMapping("/student/{studentRegisterNumber}")
    ResponseEntity<List<Application>> getApplicationsByStudent(
            @PathVariable String studentRegisterNumber) {

        return new ResponseEntity<>(
                applicationService
                        .getApplicationsByStudent(studentRegisterNumber),
                HttpStatus.OK
        );
    }

    @GetMapping("/job/{jobId}")
    ResponseEntity<List<Application>> getApplicationsByJob(
            @PathVariable String jobId) {

        return new ResponseEntity<>(
                applicationService.getApplicationsByJob(jobId),
                HttpStatus.OK
        );
    }

    @PutMapping("/{applicationId}")
    ResponseEntity<Application> updateApplication(
            @PathVariable String applicationId,
            @RequestBody Application application) {

        return new ResponseEntity<>(
                applicationService.updateApplication(
                        applicationId,
                        application
                ),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{applicationId}")
    ResponseEntity<String> deleteApplication(
            @PathVariable String applicationId) {

        applicationService.deleteApplication(applicationId);

        return new ResponseEntity<>(
                "Application deleted successfully",
                HttpStatus.OK
        );
    }
}