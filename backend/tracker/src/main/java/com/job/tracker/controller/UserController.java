package com.job.tracker.controller;

import com.job.tracker.model.Users;
import com.job.tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/register")
    public void register(@RequestBody Users user) {
        service.register(user);
    }

    @GetMapping("/login")
    public boolean login(@RequestBody Users user){
        return service.login(user);
    }

}
