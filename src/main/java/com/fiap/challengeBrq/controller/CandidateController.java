package com.fiap.challengeBrq.controller;


import com.fiap.challengeBrq.dto.CandidateDto;
import com.fiap.challengeBrq.entities.Candidate;
import com.fiap.challengeBrq.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/candidate")
public class CandidateController {

    private CandidateService service;

    @Autowired
    public CandidateController(CandidateService service) {
        this.service = service;
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public CandidateDto findByName(@PathVariable String name){
       return service.findByName(name)
               .map(candidate ->
                   new CandidateDto().convertCandidate(candidate))
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }


    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public CandidateDto findByEmail(@PathVariable String email){
        return service.findByEmail(email).
                map(candidate ->
                        new CandidateDto().convertCandidate(candidate))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }


    @GetMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public CandidateDto findByCpf(@PathVariable String cpf){
       return service.findByCpf(cpf)
                .map(candidate -> new CandidateDto().convertCandidate(candidate))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    @GetMapping("/skill/{skill}")
    @ResponseStatus(HttpStatus.OK)
    public Page<CandidateDto> findBySkill(@PathVariable String skill, Pageable pageable){
        Page<Candidate> result = service.findBySkills(skill, pageable);
        List<CandidateDto> list = result.getContent()
                .stream()
                .map(candidate -> {
                    CandidateDto dtoObj = new CandidateDto()
                            .convertCandidate(candidate);
                    return dtoObj;
                }).collect(Collectors.toList());

        return new PageImpl<>(list, pageable, result.getTotalElements());
    }

    @GetMapping("/certification/{certification}")
    @ResponseStatus(HttpStatus.OK)
    public Page<CandidateDto> findByCertifications(@PathVariable String certification, Pageable pageable){
        Page<Candidate> result = service.findByCertifications(certification, pageable);
        List<CandidateDto> list = result.getContent()
                .stream()
                .map(candidate -> {
                    CandidateDto dtoObj = new CandidateDto()
                            .convertCandidate(candidate);
                    return dtoObj;
                }).collect(Collectors.toList());

        return new PageImpl<>(list, pageable, result.getTotalElements());
    }

    @GetMapping("/certification/{certification}/skill/{skill}")
    @ResponseStatus(HttpStatus.OK)
    public Page<CandidateDto> findByCertificationsAndSkill(@PathVariable String certification, @PathVariable String skill, Pageable pageable){
        Page<Candidate> result = service.findByCertificationsAndSkill(certification, skill, pageable);
        List<CandidateDto> list = result.getContent()
                .stream()
                .map(candidate -> {
                    CandidateDto dtoObj = new CandidateDto()
                            .convertCandidate(candidate);
                    return dtoObj;
                }).collect(Collectors.toList());

        return new PageImpl<>(list, pageable, result.getTotalElements());
    }

}
