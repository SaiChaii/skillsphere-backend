package com.example.skillsphere.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ConnectionRequest {

    public enum RequestStatus {
        PENDING,
        ACCEPTED,
        REJECTED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JsonBackReference(value = "user-learner")
//    private AppUser learner;
//
//    @ManyToOne
//    @JsonBackReference(value = "user-mentor")
//    private AppUser mentor;

    @ManyToOne
    private Skill skill;

    private String message;

    @Enumerated(EnumType.STRING)
    private RequestStatus status; // Enum: PENDING, ACCEPTED, REJECTED

    public ConnectionRequest(Long id, Skill skill, String message, RequestStatus status) {
        this.id = id;
        this.skill = skill;
        this.message = message;
        this.status = status;
    }

    public ConnectionRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}

