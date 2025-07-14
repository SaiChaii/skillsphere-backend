package com.example.skillsphere.demo.controller;

import com.example.skillsphere.demo.Entity.AppUser;
import com.example.skillsphere.demo.Entity.Skill;
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
    public List<Skill> getAllSkills(){
        return s.getAllSkills();
    }

    @PostMapping("")
    public ResponseEntity<?> addSkill(@RequestBody Skill newSkill){
        String res=s.addSkill(newSkill);
        if(res.equals("Success")) return ResponseEntity.ok(res);
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<?> getSkillById(@PathVariable long user_id){
        try{
            AppUser user=u.getUserById(user_id);
            return ResponseEntity.ok(user.getUserSkills());
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> getSkillbyWord(@RequestParam("name") String key){
        List<Skill> skill_list=s.getSkillsByKey(key);
        if(skill_list.isEmpty()){
            return ResponseEntity.ok("No skills with the entered words");
        }
        else {
            return ResponseEntity.ok(skill_list);
        }
    }

    @GetMapping("/mentors")
    public ResponseEntity<?> getMentorBySkill(@RequestParam("skill") String skill){
        List<AppUser> users=s.getMentorBySkill(skill);
        if(users.isEmpty()) return ResponseEntity.ok("No users with this skill");
        else return ResponseEntity.ok(users);
    }
}
