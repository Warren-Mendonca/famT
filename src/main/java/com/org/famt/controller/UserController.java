package com.org.famt.controller;

import com.org.famt.entity.AppUser;
import com.org.famt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value = "/req/signup", consumes = "application/json")
    public String saveUser(@RequestBody AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return userRepository.save(appUser);
    }

    @GetMapping("/user/{id}")
    public AppUser getUser(@PathVariable("id") String id) {
        return userRepository.getUser(id);
    }

}
