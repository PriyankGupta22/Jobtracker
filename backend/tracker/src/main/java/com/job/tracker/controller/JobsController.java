package com.job.tracker.controller;

import com.job.tracker.model.Jobs;
import com.job.tracker.model.JobsHistory;
import com.job.tracker.service.JobsService;
import com.job.tracker.service.jobsHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobsController {

    Jobs jobs;

    @Autowired
    JobsService service;

    @Autowired
    jobsHistoryService jobsHistoryService;

    @GetMapping("/")
    public String Greet() {
        return "Good Morning";
    }

    @GetMapping("/jobs")
    public List<Jobs> getJobs(){
        return service.getJobs();
    }

    @PostMapping("/jobs")
    public void addJobs(@RequestBody Jobs jobs){
        service.addJobs(jobs);
    }

    @PutMapping("/jobs/{id}")
    public void updateJobs(@RequestBody Jobs jobs , @PathVariable int id){
        service.updateJobs(id, jobs);
    }

    @DeleteMapping("/jobs/{id}")
    public void deleteJob(@PathVariable int id){
        service.deleteJob(id);
    }

    @GetMapping("/jobs-history")
    public List<JobsHistory> getHistory(){
        return jobsHistoryService.getJobsHistory();
    }

    @GetMapping("/jobs/filter-companyName/{constraint}")
    public List<Jobs> getFilteredJobs(@PathVariable String constraint){
        return service.getFilterCompany(constraint);
    }

    @GetMapping("/jobs/filter-location/{constraint}")
    public List<Jobs> getFilteredJobsLocation(@PathVariable String constraint){
        return service.getFilterLocation(constraint);
    }
}
