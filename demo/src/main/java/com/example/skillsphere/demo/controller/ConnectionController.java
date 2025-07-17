package com.example.skillsphere.demo.controller;

import com.example.skillsphere.demo.Response.ApiResponse;
import com.example.skillsphere.demo.dto.ConnectionRequestPayload;
import com.example.skillsphere.demo.service.ConnectionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requests")
public class ConnectionController {

    @Autowired
    private ConnectionRequestService connectionRequestService;

    @PostMapping("/connect")
    public ResponseEntity<ApiResponse<?>> connectionRequest(@RequestBody ConnectionRequestPayload newConnection){
        String message=connectionRequestService.sendRequest(newConnection);
        if(message.equals("True")) return ResponseEntity.ok(new ApiResponse<>("Success", 200, null, "Request Sent"));
        else {
            return ResponseEntity.ok(new ApiResponse<>("error", 404, null, "Request already sent"));
        }
    }
}
