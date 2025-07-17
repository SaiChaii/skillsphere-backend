package com.example.skillsphere.demo.repository;

import com.example.skillsphere.demo.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepo extends JpaRepository<Skill,Long> {
    Optional<Skill> findBySkillNameIgnoreCase(String skillName);
}
