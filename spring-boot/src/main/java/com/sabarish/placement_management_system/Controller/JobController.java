package com.sabarish.placement_management_system;

import com.sabarish.placement_management_system.Models.Job;
import com.sabarish.placement_management_system.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    ResponseEntity<Job> createJob(@RequestBody Job job) {

        Job savedJob = jobService.createJob(job);

        return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Job>> getAllJobs() {

        return new ResponseEntity<>(
                jobService.getAllJobs(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{jobId}")
    ResponseEntity<Job> getJobById(
            @PathVariable String jobId) {

        Job job = jobService.getJobById(jobId);

        if (job == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @GetMapping("/company/{companyId}")
    ResponseEntity<List<Job>> getJobsByCompany(
            @PathVariable String companyId) {

        return new ResponseEntity<>(
                jobService.getJobsByCompany(companyId),
                HttpStatus.OK
        );
    }

    @PutMapping("/{jobId}")
    ResponseEntity<Job> updateJob(
            @PathVariable String jobId,
            @RequestBody Job job) {

        return new ResponseEntity<>(
                jobService.updateJob(jobId, job),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{jobId}")
    ResponseEntity<String> deleteJob(
            @PathVariable String jobId) {

        jobService.deleteJob(jobId);

        return new ResponseEntity<>(
                "Job deleted successfully",
                HttpStatus.OK
        );
    }
}