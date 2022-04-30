package com.fiap.challengeBrq;

import com.fiap.challengeBrq.entities.Candidate;
import com.fiap.challengeBrq.entities.Certification;
import com.fiap.challengeBrq.entities.Skill;
import com.fiap.challengeBrq.entities.enums.Gender;
import com.fiap.challengeBrq.repo.CandidateRepository;
import com.fiap.challengeBrq.repo.CertificationRepository;
import com.fiap.challengeBrq.repo.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class ChallengeBrqApplication{


	public static void main(String[] args) {
		SpringApplication.run(ChallengeBrqApplication.class, args);
	}

}
