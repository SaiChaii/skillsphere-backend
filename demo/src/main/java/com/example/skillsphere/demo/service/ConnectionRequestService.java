package com.example.skillsphere.demo.service;

import com.example.skillsphere.demo.Entity.AppUser;
import com.example.skillsphere.demo.Entity.ConnectionRequest;
import com.example.skillsphere.demo.Entity.Skill;
import com.example.skillsphere.demo.dto.ConnectionRequestPayload;
import com.example.skillsphere.demo.repository.ConnectionRepo;
import com.example.skillsphere.demo.repository.SkillRepo;
import com.example.skillsphere.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnectionRequestService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SkillRepo skillRepo;

    @Autowired
    private ConnectionRepo connectionRepo;

    public String sendRequest(ConnectionRequestPayload newConnection) {
        try {
            AppUser sender = userRepo.findById(newConnection.getSenderId()).orElseThrow();
            AppUser receiver = userRepo.findById(newConnection.getReceiverId()).orElseThrow();
            Skill skill = skillRepo.findById(newConnection.getSkillId()).orElseThrow();
            String message = newConnection.getMessage();

            if (sender.getRequestsSent() != null &&
                    sender.getRequestsSent().stream().anyMatch(x -> x.getMentor().equals(receiver))) {
                return "False";
            } else {
                ConnectionRequest connectionRequest = new ConnectionRequest(null,sender, receiver, skill, message, ConnectionRequest.RequestStatus.PENDING);
                connectionRepo.save(connectionRequest);
                sender.getRequestsSent().add(connectionRequest);
                receiver.getRequestsReceived().add(connectionRequest);
                return "True";
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return "Error";
        }
    }
}
