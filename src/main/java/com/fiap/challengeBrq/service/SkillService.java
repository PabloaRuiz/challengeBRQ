package com.fiap.challengeBrq.service;

import com.fiap.challengeBrq.entities.Certification;
import com.fiap.challengeBrq.entities.Skill;
import com.fiap.challengeBrq.repo.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

    private SkillRepository repository;

    @Autowired
    public SkillService(SkillRepository repository) {
        this.repository = repository;
    }

    public Skill saveSkill(Skill skill) {
        return repository.save(skill);
    }

}
