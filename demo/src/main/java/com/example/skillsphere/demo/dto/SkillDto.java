package com.example.skillsphere.demo.dto;

public class SkillDto {
    private long skillId;
    private String skillName;
    private String skillDesc;

    public SkillDto(long skillId, String skillName, String skillDesc) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.skillDesc = skillDesc;
    }

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
}
