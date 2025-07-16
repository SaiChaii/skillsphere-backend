package com.example.skillsphere.demo.Response;

import com.example.skillsphere.demo.Entity.AppUser;

import java.util.List;

public class ApiResponse<T>  {
    private String status;
    private int statusCode;
    private T data;
    private String message;
    public ApiResponse(String status, int statusCode, T data, String message) {
        this.status = status;
        this.statusCode = statusCode;
        this.data = data;
        this.message = message;
    }

    public String getStatus() { return status; }
    public Integer getStatusCode() { return statusCode;}
    public T getData() { return data; }
    public String getMessage() { return message; }
}
