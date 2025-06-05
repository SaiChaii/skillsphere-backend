package com.example.skillsphere.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity

public class User {

    public enum Role {
        MENTOR,
        LEARNER,
        BOTH
    }


    private Long id;
    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

}
