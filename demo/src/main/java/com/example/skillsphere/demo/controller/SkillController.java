package com.example.skillsphere.demo.controller;

import com.example.skillsphere.demo.Entity.AppUser;
import com.example.skillsphere.demo.Entity.Skill;
import com.example.skillsphere.demo.Response.ApiResponse;
import com.example.skillsphere.demo.dto.AppUserDto;
import com.example.skillsphere.demo.service.SkillService;
import com.example.skillsphere.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    private SkillService s;
    @Autowired
    private UserService u;

    @GetMapping("")
    public ResponseEntity<ApiResponse<?>> getAllSkills(){

        List<Skill> response = s.getAllSkills();

        return ResponseEntity.ok(new ApiResponse<>("success", 200, response, "Skills Fetched successfully"));
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<?>> addSkill(@RequestBody Skill newSkill){
        String res=s.addSkill(newSkill);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, res, "Skills fetched Successfully"));
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<?> getSkillById(@PathVariable long user_id){

            AppUserDto user=u.getUserById(user_id);
            return ResponseEntity.ok(new ApiResponse<>("success", 200, user.getUserSkills(),"Skills for the user fetched succsessfully"));



    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<?>> getSkillbyWord(@RequestParam("name") String key){
        List<Skill> skill_list=s.getSkillsByKey(key);
        if(skill_list.isEmpty()){
            return ResponseEntity.ok(new ApiResponse<>("Success", 200, null, "No skills with the provided keyword"));
        }
        else {
            return ResponseEntity.ok(new ApiResponse<>("Sucess", 200, skill_list,"These are the skills with keyword provided"));
        }
    }

    @GetMapping("/mentors")
    public ResponseEntity<ApiResponse<?>> getMentorBySkill(@RequestParam("skill") String skill){
        List<AppUser> users=s.getMentorBySkill(skill);
        if(users.isEmpty()) {
            return ResponseEntity.ok(new ApiResponse<>("Success", 200, null, "No users with this skill"));
        }
        else return ResponseEntity.ok(new ApiResponse<>("Success", 200, users, "Successfully fetched the users for the mentor"));
    }
}
