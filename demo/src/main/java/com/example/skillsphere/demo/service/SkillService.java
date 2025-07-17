package com.example.skillsphere.demo.service;

import com.example.skillsphere.demo.Entity.AppUser;
import com.example.skillsphere.demo.Entity.Skill;
import com.example.skillsphere.demo.repository.SkillRepo;
import com.example.skillsphere.demo.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SkillService {

    @Autowired
    private SkillRepo s;
    @Autowired
    private UserRepo u;

    public List<Skill> getAllSkills(){
        List<Skill> all=s.findAll();
        return all;
    }

    public List<Skill> getSkillById(Long userId) {
        AppUser user= u.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getUserSkills();
    }

    public List<Skill> getSkillsByKey(String key) {
        List<Skill> all=s.findAll();
        List<Skill> filteredSkills=all.stream().filter((x)->x.getSkillName().toLowerCase().contains(key.toLowerCase())).collect(Collectors.toList());
        return filteredSkills;
    }

    public List<AppUser> getMentorBySkill(String skill) {
        List<AppUser> allUsers=u.findAll();
//        System.out.println("Inside the service layer");
        List<AppUser> res=allUsers.stream().filter((x)->x.getUserSkills().stream().anyMatch((t)->t.getSkillName().toLowerCase().contains(skill.toLowerCase()))).collect(Collectors.toList());
//        System.out.println(res);
        return res;
    }

    public int addSkill(Skill newSkill) {
        String skillName=newSkill.getSkillName();
        Optional<Skill> existing = s.findBySkillNameIgnoreCase(skillName);
        if(existing.isPresent()){
            return 0;
        }

        else{
            try{
                s.save(newSkill);
                return 1;
            } catch (Exception e) {
                throw new RuntimeException("Error saving skill", e);
            }

        }

    }

    public List<Skill> getSkillsOnSearch(String searchText) {
        try {
            return s.findBySkillNameContainingIgnoreCase(searchText);
        } catch (Exception e) {
            throw new RuntimeException("Error finding skills with the given search text: " + searchText, e);
        }
    }

}
