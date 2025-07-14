package com.example.skillsphere.demo.controller;

import com.example.skillsphere.demo.Entity.AppUser;
import com.example.skillsphere.demo.Entity.Skill;
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

    @GetMapping("")
    public List<Skill> getAllSkills(){
        return s.getAllSkills();
    }

    @PostMapping("")
    public ResponseEntity<String> addSkill(@RequestBody Skill newSkill){
        String res=s.addSkill(newSkill);
        if(res.equals("Success")) return ResponseEntity.ok(res);
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{user_id}")
    public List<Skill> getSkillById(@PathVariable long user_id){
        return s.getSkillById(user_id);
    }

    @GetMapping("/search")
    public List<Skill> getSkillbyWord(@RequestParam("name") String key){
        return s.getSkillsByKey(key);
    }

    @GetMapping("/mentors")
    public List<AppUser> getMentorBySkill(@RequestParam("skill") String skill){
        return s.getMentorBySkill(skill);
    }
}
