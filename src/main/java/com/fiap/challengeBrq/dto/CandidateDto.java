package com.fiap.challengeBrq.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.challengeBrq.entities.Candidate;
import com.fiap.challengeBrq.entities.Certification;
import com.fiap.challengeBrq.entities.Skill;
import com.fiap.challengeBrq.entities.enums.Gender;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CandidateDto {

    @JsonProperty("Nome")
    private String name;

    @JsonProperty("CPF")
    private String cpf;

    @JsonProperty("E-mail")
    private String email;

    @JsonProperty("Telefone")
    private Integer telephone;

    @JsonProperty("Gênero")
    private Gender gender;

    @JsonProperty("Data de nascimento")
    private LocalDate birth;

    @JsonProperty("Certificações")
    private Set<Certification> certifications;

    @JsonProperty("Skills")
    private Set<Skill> skills;


    public CandidateDto convertCandidate (Candidate candidate) {
        return new CandidateDto(
                candidate.getName(),
                candidate.getCpf(),
                candidate.getEmail(),
                candidate.getTelephone(),
                candidate.getGender(),
                candidate.getBirth(),
                candidate.getCertifications(),
                candidate.getSkills());
    }
}
