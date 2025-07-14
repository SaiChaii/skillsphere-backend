package com.example.skillsphere.demo.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="USERS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppUser {

    public enum Role {
        MENTOR,
        LEARNER,
        BOTH
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Skill> userSkills;

    @OneToMany(mappedBy = "learner", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "user-learner")
    private List<ConnectionRequest> requestsSent;

    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "user-mentor")
    private List<ConnectionRequest> requestsReceived;

    @ManyToMany
    private List<AppUser> connectedUsers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Skill> getUserSkills() {
        return userSkills;
    }

    public void setUserSkills(List<Skill> userSkills) {
        this.userSkills = userSkills;
    }

    public List<ConnectionRequest> getRequestsSent() {
        return requestsSent;
    }

    public void setRequestsSent(List<ConnectionRequest> requestsSent) {
        this.requestsSent = requestsSent;
    }

    public List<ConnectionRequest> getRequestsReceived() {
        return requestsReceived;
    }

    public void setRequestsReceived(List<ConnectionRequest> requestsReceived) {
        this.requestsReceived = requestsReceived;
    }

    public List<AppUser> getConnectedUsers() {
        return connectedUsers;
    }

    public void setConnectedUsers(List<AppUser> connectedUsers) {
        this.connectedUsers = connectedUsers;
    }
}
