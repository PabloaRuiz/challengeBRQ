package com.fiap.challengeBrq.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "tb_skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_skill")
    private Long id;
    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_skill_candidate")
    private Candidate candidateSkill;

    public Skill() {
    }

    public Skill(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Candidate getCandidateSkill() {
        return candidateSkill;
    }

    public void setCandidateSkill(Candidate candidateSkill) {
        this.candidateSkill = candidateSkill;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
