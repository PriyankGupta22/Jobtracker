package com.job.tracker.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "jobs_history")
public class JobsHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String job;
    private LocalDate change_date;
    private String status;
    private String company;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public LocalDate getChange_date() {
        return change_date;
    }

    public void setChange_date(LocalDate change_date) {
        this.change_date = change_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
