package com.job.tracker.service;

import com.job.tracker.model.Jobs;
import com.job.tracker.model.JobsHistory;
import com.job.tracker.repository.JobsHistoryRepo;
import com.job.tracker.repository.JobsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobsService {

    @Autowired
    JobsRepo repo;

    @Autowired
    JobsHistoryRepo jobHistoryRepo;

    public List<Jobs> getJobs() {
        return repo.findAll();
    }

    public void addJobs(Jobs jobs) {
        repo.save(jobs);
    }

    public void updateJobs(int id , Jobs jobs) {
        Jobs job = repo.findById(id).orElse(null);

        if(!job.getStatus().equals(jobs.getStatus())){
            job.setStatus(jobs.getStatus());

            JobsHistory jobsHistory = new  JobsHistory();
            jobsHistory.setStatus(jobs.getStatus());
            jobsHistory.setCompany(jobs.getCompanyName());
            jobsHistory.setChange_date(LocalDate.now());
            jobsHistory.setJob(jobs.getJobRole());
            jobHistoryRepo.save(jobsHistory);
        }

        job.setId(jobs.getId());
        job.setJobRole(jobs.getJobRole());
        job.setJobDescription(jobs.getJobDescription());
        job.setApplyDate(jobs.getApplyDate());
        job.setDeadline(jobs.getDeadline());
        job.setLocation(jobs.getLocation());
        job.setStatus(jobs.getStatus());
        job.setSalary(jobs.getSalary());
        job.setCompanyName(jobs.getCompanyName());



        repo.save(job);
    }

    public void deleteJob(int id) {
        repo.deleteById(id);
    }

    public List<Jobs> getFilterCompany(String constraint) {
        List<Jobs> list = repo.findAll();
        List<Jobs> finalList = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getCompanyName().toLowerCase().equals(constraint.toLowerCase())){
                finalList.add(list.get(i));
            }
        }
        return finalList;
    }

    public List<Jobs> getFilterLocation(String constraint) {
        List<Jobs> job = repo.findAll();
        List<Jobs> list  = new ArrayList<>();
        for(int i=0;i<job.size();i++){
            if(job.get(i).getLocation().toLowerCase().equals(constraint.toLowerCase())){
                list.add(job.get(i));
            }
        }
        return list;
    }
}
