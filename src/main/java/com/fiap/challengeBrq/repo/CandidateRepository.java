package com.fiap.challengeBrq.repo;

import com.fiap.challengeBrq.entities.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Set;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Candidate findByNameLike(String name);

    Candidate findByEmail(String email);

    Candidate findByCpf(String cpf);

    @Query(value = "SELECT * FROM tb_candidate as t1 inner join tb_skill as t2 on t1.id_candidate = t2.id_skill_candidate where t2.description = :skills",
    nativeQuery = true)
    Page<Candidate> findBySkills(String skills, Pageable pageable);

    @Query(value = "SELECT * FROM tb_candidate as t1 inner join tb_certification as t2 on t1.id_candidate = t2.id_certification_candidate where t2.description = :certifications",
            nativeQuery = true)
    Page<Candidate> findByCertifications(String certifications, Pageable pageable);

}