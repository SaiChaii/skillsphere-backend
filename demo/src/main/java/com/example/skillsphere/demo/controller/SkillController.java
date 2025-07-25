package com.example.skillsphere.demo.controller;

import com.example.skillsphere.demo.Entity.Skill;
import com.example.skillsphere.demo.Response.ApiResponse;
import com.example.skillsphere.demo.dto.AppUserDto;
import com.example.skillsphere.demo.dto.SkillDto;
import com.example.skillsphere.demo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    private SkillService s;
    //@Autowired
    // private UserService u;

    @GetMapping("")
    public ResponseEntity<ApiResponse<?>> getAllSkills(){ // get all skills

        List<SkillDto> response = s.getAllSkills();

        return ResponseEntity.ok(new ApiResponse<>("Success", 200, response, "Skills Fetched successfully"));
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<?>> addSkill(@RequestBody Skill newSkill){  // add new skill
        int res=s.addSkill(newSkill);
        if(res==1) return ResponseEntity.ok(new ApiResponse<>("Success", 200, null, "Skill added Successfully"));
        else return ResponseEntity.ok(new ApiResponse<>("Failed", 409, null, "Skill already exists"));

    }

//    @GetMapping("/user/{user_id}")
//    public ResponseEntity<?> getSkillById(@PathVariable long user_id){
//
//            AppUserDto user=u.getUserById(user_id);
//            return ResponseEntity.ok(new ApiResponse<>("Success", 200, user.getUserSkills(),"Skills for the user fetched successfully"));
//
//
//
//    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<?>> getSkillbyWord(@RequestParam("name") String key){
        List<SkillDto> skill_list=s.getSkillsOnSearch(key,"all"); // all skills having those key words
        return ResponseEntity.ok(new ApiResponse<>("Success", 200, skill_list,"These are the skills with keyword provided"));
    }

//    @GetMapping("/mentors")
//    public ResponseEntity<ApiResponse<?>> getMentorBySkill(@RequestParam("skill") String skill){
//        List<AppUserDto> users=s.getMentorBySkill(skill);
//        return ResponseEntity.ok(new ApiResponse<>("Success", 200, users, "Successfully fetched the users for the mentor"));
//    }

    @GetMapping("/query")
    public ResponseEntity<ApiResponse<?>> getSkillsOnSearch(@RequestParam("search") String searchText){
        List<SkillDto> skills=s.getSkillsOnSearch(searchText,"search");  // only 5 are shown
        return ResponseEntity.ok(new ApiResponse<>("Success",200,skills,"Successfully fetched the skills on the text"));
    }
}
