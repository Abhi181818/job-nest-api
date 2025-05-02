package com.jobnest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jobnest.dvo.Job;
import com.jobnest.service.JobService;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin("*")

public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    @PostMapping
    public Job createJob(@RequestBody Job job) {
        if (job.getImageUrl() == null) {
            job.setImageUrl("404.jpg");
        }
        return jobService.createJob(job);
    }

}