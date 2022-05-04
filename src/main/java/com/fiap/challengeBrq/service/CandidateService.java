package com.fiap.challengeBrq.service;


import com.fiap.challengeBrq.entities.Candidate;
import com.fiap.challengeBrq.exception.CandidateNotFoundException;
import com.fiap.challengeBrq.repo.CandidateRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateService {

    private CandidateRepository repository;

    @Autowired
    public CandidateService(CandidateRepository repository) {
        this.repository = repository;
    }

    public Candidate saveCadidate(Candidate candidate) {
        return repository.save(candidate);
    }

    public Optional<Candidate> findByName(String name) {
        if (repository.findByNameLike(name).isEmpty()) {
            throw new CandidateNotFoundException();
        }  Optional<Candidate> candidate = repository.findByNameLike(name);
            return candidate;
    }

    public Optional<Candidate>  findByEmail(String email) {
       if(repository.findByEmail(email).isEmpty()) {
           throw new CandidateNotFoundException();
       }
        Optional<Candidate> candidate = repository.findByEmail(email);
        return candidate;

    }

    public Optional<Candidate> findByCpf(String cpf) {
        if (repository.findByCpf(cpf).isEmpty()) {
         throw new CandidateNotFoundException();
        }
        Optional<Candidate> candidate = repository.findByCpf(cpf);
        return candidate;
    }

    public Page<Candidate> findBySkills(String skills, Pageable pageable) {
        return repository.findBySkills(skills, pageable);
    }

    public Page<Candidate> findByCertifications(String certifications, Pageable pageable) {
        return repository.findByCertifications(certifications, pageable);
    }

    public Page<Candidate> findByCertificationsAndSkill(String certifications, String skills, Pageable pageable) {
        return repository.findByCertificationsAndSkills(certifications, skills, pageable);
    }
}
