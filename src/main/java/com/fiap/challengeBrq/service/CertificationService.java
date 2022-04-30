package com.fiap.challengeBrq.service;

import com.fiap.challengeBrq.entities.Certification;
import com.fiap.challengeBrq.repo.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificationService {

    private CertificationRepository repository;

    @Autowired
    public CertificationService(CertificationRepository repository) {
        this.repository = repository;
    }

    public Certification saveCertification(Certification certification) {
        return repository.save(certification);
    }
}
