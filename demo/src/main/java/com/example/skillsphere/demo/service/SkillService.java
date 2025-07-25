package com.example.skillsphere.demo.service;

import com.example.skillsphere.demo.Entity.AppUser;
import com.example.skillsphere.demo.Entity.Skill;
import com.example.skillsphere.demo.dto.AppUserDto;
import com.example.skillsphere.demo.repository.SkillRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SkillService {

    @Autowired
    private SkillRepo s;
    @Autowired
    //private UserRepo u;

    public List<Skill> getAllSkills(){
        List<Skill> all=s.findAll();
        if(all.isEmpty()){
            throw new EntityNotFoundException("No skills found");
        }
        return all;
    }

//    public List<Skill> getSkillOfUserByUserId(Long userId) {
//        AppUser user= u.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
//        return user.getUserSkills();
//    }

//    public List<AppUserDto> getMentorBySkill(String skill) {
//        List<AppUser> res=u.findByUserSkillsSkillNameContainingIgnoreCase(skill);
//        if(res.isEmpty()){
//            throw new EntityNotFoundException("No user with this Skill");
//        }
//        return res.stream()
//                .map(t -> new AppUserDto(t.getId(), t.getName(),t.getEmail(),t.getPassword(),
//                        t.getRole(),t.getUserSkills(),t.getRequestsSent(),t.getRequestsReceived(),t.getConnectedUsers()
//                )).collect(Collectors.toList());
//
//    }

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

    public List<Skill> getSkillsOnSearch(String searchText,String type) {

        try {
            if(type.equals("search")) { //search skill by skillname
                Pageable topFive = PageRequest.of(0, 5);
                Page<Skill> skills = s.findBySkillNameContainingIgnoreCase(searchText, topFive);

                if (skills.isEmpty()) {
                    throw new EntityNotFoundException("Skill not found");
                }
                return skills.toList();
            }
            else{ //type="all" get all skills
                List<Skill> all=s.findBySkillNameContainingIgnoreCase(searchText);
                if(all.isEmpty()) {
                    throw new EntityNotFoundException("Skill not found");
                }
                return all;
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
