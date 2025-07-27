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
    private Long connectionFromId;
    private Long connectionToId;
    private String message;

    @Enumerated(EnumType.STRING)
    private RequestStatus status; // Enum: PENDING, ACCEPTED, REJECTED

    public ConnectionRequest(Long id, Long connectionFromId, Long connectionToId, String message, RequestStatus status) {
        this.id = id;
        this.connectionFromId = connectionFromId;
        this.connectionToId = connectionToId;
        this.message = message;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getConnectionFromId() {
        return connectionFromId;
    }

    public void setConnectionFromId(Long connectionFromId) {
        this.connectionFromId = connectionFromId;
    }

    public Long getConnectionToId() {
        return connectionToId;
    }

    public void setConnectionToId(Long connectionToId) {
        this.connectionToId = connectionToId;
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

