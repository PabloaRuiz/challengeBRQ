package com.fiap.challengeBrq.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_certification")
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_certification")
    private Long id;
    private String description;
    private LocalDate conclusion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_certification_candidate")
    private Candidate candidateCertification;

    public Certification() {
    }

    public Certification(Long id, String description, LocalDate conclusion) {
        this.id = id;
        this.description = description;
        this.conclusion = conclusion;
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

    public LocalDate getConclusion() {
        return conclusion;
    }

    public void setConclusion(LocalDate conclusion) {
        this.conclusion = conclusion;
    }

    public Candidate getCandidateCertification() {
        return candidateCertification;
    }

    public void setCandidateCertification(Candidate candidateCertification) {
        this.candidateCertification = candidateCertification;
    }

    @Override
    public String toString() {
        return "Certification{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", conclusion=" + conclusion +
                '}';
    }

}
