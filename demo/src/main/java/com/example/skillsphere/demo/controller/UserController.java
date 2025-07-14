package com.example.skillsphere.demo.controller;

import com.example.skillsphere.demo.Entity.AppUser;
import com.example.skillsphere.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{userId}")
    public AppUser getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("")
    public List<AppUser> getAllUsers(){
        return userService.getAll();
    }
}
