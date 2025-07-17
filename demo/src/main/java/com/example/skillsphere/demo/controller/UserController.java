package com.example.skillsphere.demo.controller;

import com.example.skillsphere.demo.Entity.AppUser;
import com.example.skillsphere.demo.Response.ApiResponse;
import com.example.skillsphere.demo.dto.AppUserDto;
import com.example.skillsphere.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<?>> getUserById(@PathVariable Long userId) {

            AppUserDto user = userService.getUserById(userId);

            return ResponseEntity.ok( new ApiResponse<>("success", 200, user, "User fetched successfully"));

    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<?>> getAllUsers(){

            List<AppUserDto> users = userService.getAll();
            Map<String, Object> data = new HashMap<>();
            data.put("users", users);
            System.out.println(users.get(0));
            return ResponseEntity.ok(new ApiResponse<>("success", 200, data, "Users fetched successfully"));


    }
}
