package com.example.skillsphere.demo.service;

import com.example.skillsphere.demo.Entity.AppUser;
import com.example.skillsphere.demo.Entity.ConnectionRequest;
import com.example.skillsphere.demo.repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo user;


    public AppUser getUserById(Long userId) {
        return user.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + userId));
    }

    public List<AppUser> getAll() {
        return user.findAll();
    }
}
