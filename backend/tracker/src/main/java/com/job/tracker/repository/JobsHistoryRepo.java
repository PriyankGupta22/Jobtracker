package com.job.tracker.repository;

import com.job.tracker.model.JobsHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsHistoryRepo extends JpaRepository<JobsHistory, Integer> {

}

