package com.job.tracker.service;

import com.job.tracker.model.Users;
import com.job.tracker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    public void register(Users user) {
        repo.save(user);
    }

    public boolean login(Users user) {
        return repo.findAll().stream()
                .anyMatch(existingUser -> existingUser.getUsername().equals(user.getUsername()) &&
                        existingUser.getPassword().equals(user.getPassword()));
    }
}
