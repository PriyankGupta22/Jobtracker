package com.job.tracker.repository;

import com.job.tracker.model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface JobsRepo extends JpaRepository<Jobs, Integer> {

}
