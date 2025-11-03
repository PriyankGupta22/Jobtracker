package com.job.tracker.service;

import com.job.tracker.model.Jobs;
import com.job.tracker.repository.JobsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobsService {

    Jobs jobs;

    @Autowired
    JobsRepo repo;

    public List<Jobs> getJobs() {
        return repo.findAll();
    }

    public void addJobs(Jobs jobs) {
        repo.save(jobs);
    }

    public void updateJobs(int id , Jobs jobs) {
        Jobs job = repo.findById(id).orElse(null);

        job.setId(jobs.getId());
        job.setJobRole(jobs.getJobRole());
        job.setJobDescription(jobs.getJobDescription());
        job.setApplyDate(jobs.getApplyDate());
        job.setDeadline(jobs.getDeadline());
        job.setLocation(jobs.getLocation());
        job.setSalary(jobs.getSalary());
        job.setStatus(jobs.getStatus());
        job.setCompanyName(jobs.getCompanyName());

        repo.save(job);
    }

    public void deleteJob(int id) {
        repo.deleteById(id);
    }
}
