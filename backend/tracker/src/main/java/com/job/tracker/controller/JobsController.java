package com.job.tracker.controller;

import com.job.tracker.model.Jobs;
import com.job.tracker.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobsController {

    Jobs jobs;

    @Autowired
    JobsService service;

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

}
