package com.job.tracker.service;

import com.job.tracker.model.JobsHistory;
import com.job.tracker.repository.JobsHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class jobsHistoryService {

    JobsHistory jobsHistory;

    @Autowired
    JobsHistoryRepo jobsHistoryRepo;

    public List<JobsHistory> getJobsHistory() {
        return jobsHistoryRepo.findAll();
    }

}
