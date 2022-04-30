package com.fiap.challengeBrq.service;


import com.fiap.challengeBrq.entities.Candidate;
import com.fiap.challengeBrq.repo.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

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

    public Candidate findByName(String name) {
        return repository.findByNameLike(name);
    }

    public Candidate getByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Candidate getByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    public Page<Candidate> findBySkills(String skills, Pageable pageable) {
        return repository.findBySkills(skills, pageable);
    }

    public Page<Candidate> findByCertifications(String certifications, Pageable pageable) {
        return repository.findByCertifications(certifications, pageable);
    }
}
