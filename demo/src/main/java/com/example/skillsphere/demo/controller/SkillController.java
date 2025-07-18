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

        return ResponseEntity.ok(new ApiResponse<>("Success", 200, response, "Skills Fetched successfully"));
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<?>> addSkill(@RequestBody Skill newSkill){
        int res=s.addSkill(newSkill);
        if(res==0) return ResponseEntity.ok(new ApiResponse<>("Success", 200, null, "Skill added Successfully"));
        else return ResponseEntity.ok(new ApiResponse<>("Failed", 409, null, "Skill already exists"));

    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<?> getSkillById(@PathVariable long user_id){

            AppUserDto user=u.getUserById(user_id);
            return ResponseEntity.ok(new ApiResponse<>("Success", 200, user.getUserSkills(),"Skills for the user fetched succsessfully"));



    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<?>> getSkillbyWord(@RequestParam("name") String key){
        List<Skill> skill_list=s.getSkillsOnSearch(key,"all");
        return ResponseEntity.ok(new ApiResponse<>("Success", 200, skill_list,"These are the skills with keyword provided"));
    }

    @GetMapping("/mentors")
    public ResponseEntity<ApiResponse<?>> getMentorBySkill(@RequestParam("skill") String skill){
        List<AppUserDto> users=s.getMentorBySkill(skill);
        if(users.isEmpty()) {
            return ResponseEntity.ok(new ApiResponse<>("Success", 200, null, "No users with this skill"));
        }
        else return ResponseEntity.ok(new ApiResponse<>("Success", 200, users, "Successfully fetched the users for the mentor"));
    }

    @GetMapping("/query")
    public ResponseEntity<ApiResponse<?>> getSkillsOnSearch(@RequestParam("search") String searchText){
        List<Skill> skills=s.getSkillsOnSearch(searchText,"search");
        return ResponseEntity.ok(new ApiResponse<>("Success",200,skills,"Successfully fetched the skills on the text"));
    }
}
