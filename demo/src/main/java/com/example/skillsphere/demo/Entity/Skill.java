package com.example.skillsphere.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long skillId;
    private String skillName;
    private String skillDesc;
    private List<Long> mentors_teaching;
    private List<Long> learners_enrolled;

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDesc() {
        return skillDesc;
    }

    public void setSkillDesc(String skillDesc) {
        this.skillDesc = skillDesc;
    }

    public List<Long> getMentors_teaching() {
        return mentors_teaching;
    }

    public void setMentors_teaching(List<Long> mentors_teaching) {
        this.mentors_teaching = mentors_teaching;
    }

    public List<Long> getLearners_enrolled() {
        return learners_enrolled;
    }

    public void setLearners_enrolled(List<Long> learners_enrolled) {
        this.learners_enrolled = learners_enrolled;
    }
}
