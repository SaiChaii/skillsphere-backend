package com.example.skillsphere.demo.service;

import com.example.skillsphere.demo.Entity.AppUser;
import com.example.skillsphere.demo.Entity.ConnectionRequest;
import com.example.skillsphere.demo.dto.AppUserDto;
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


    public AppUserDto getUserById(Long userId) {
        AppUser user=  this.user.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + userId));

        return new AppUserDto(user.getId(), user.getName(), user.getEmail(), user.getPassword(),
                user.getRole(), user.getUserSkills(), user.getRequestsSent(), user.getRequestsReceived(), user.getConnectedUsers());
    }

    public List<AppUserDto> getAll() {
        return user.findAll().stream()
                .map(user -> new AppUserDto(user.getId(), user.getName(), user.getEmail(), user.getPassword(),
                        user.getRole(),user.getUserSkills(),user.getRequestsSent(),user.getRequestsReceived(),user.getConnectedUsers()))
                .toList();
    }
}
