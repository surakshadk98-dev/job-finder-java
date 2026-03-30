package com.javajob.myjob.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javajob.myjob.model.Job;
import com.javajob.myjob.service.JobService;

@RestController
@RequestMapping("/jobs")
public class JobController {


    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getJobs(@RequestParam String skills) {
        return jobService.getFilteredJobs(skills);
    }
}
