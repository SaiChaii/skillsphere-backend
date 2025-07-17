package com.example.skillsphere.demo.dto;

import com.example.skillsphere.demo.Entity.AppUser;
import com.example.skillsphere.demo.Entity.ConnectionRequest;
import com.example.skillsphere.demo.Entity.Skill;

import java.util.List;

public class AppUserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private AppUser.Role role;
    private List<Skill> userSkills;
    private List<ConnectionRequest> requestsSent;
    private List<ConnectionRequest> requestsReceived;
    private List<AppUser> connectedUsers;

    public AppUserDto(Long id, String name, String email, String password, AppUser.Role role, List<Skill> userSkills,
                      List<ConnectionRequest> requestsSent, List<ConnectionRequest> requestsReceived, List<AppUser> connectedUsers) {


        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.userSkills = userSkills;
        this.requestsSent = requestsSent;
        this.requestsReceived = requestsReceived;
        this.connectedUsers = connectedUsers;
    }
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public AppUser.Role getRole() { return role; }
    public List<Skill> getUserSkills() { return userSkills; }
    public List<ConnectionRequest> getRequestsSent() { return requestsSent; }
    public List<ConnectionRequest> getRequestsReceived() {return requestsReceived; }
    public List<AppUser> getConnectedUsers() { return connectedUsers; }

}
