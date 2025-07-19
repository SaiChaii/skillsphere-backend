package com.example.skillsphere.demo.repository;


import com.example.skillsphere.demo.Entity.AppUser;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<AppUser,Long> {
    List<AppUser> findByUserSkillsSkillNameContainingIgnoreCase(String skill);
}
