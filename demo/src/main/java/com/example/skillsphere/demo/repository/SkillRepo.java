package com.example.skillsphere.demo.repository;

import com.example.skillsphere.demo.Entity.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkillRepo extends JpaRepository<Skill,Long> {
    Optional<Skill> findBySkillNameIgnoreCase(String skillName);

    Page<Skill> findBySkillNameContainingIgnoreCase(String searchText, Pageable topFive);

    List<Skill> findBySkillNameContainingIgnoreCase(String key);

}
