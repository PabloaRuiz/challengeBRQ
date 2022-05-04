package com.fiap.challengeBrq.service;

import com.fiap.challengeBrq.entities.Candidate;
import com.fiap.challengeBrq.entities.enums.Gender;
import com.fiap.challengeBrq.exception.CandidateNotFoundException;
import com.fiap.challengeBrq.repo.CandidateRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;



@ExtendWith(SpringExtension.class)
public class CandidateServiceTest {

    private CandidateService service;

    @MockBean
    private CandidateRepository repository;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        this.service = new CandidateService(repository);
    }

    private Candidate CreateCandidate() {
        return new Candidate(null, "Pablo", "44951360988", "Pabloa@Fiap.com.br", 32321388, Gender.Masculino, LocalDate.of(1998, 12, 20));
    }

    @Test
    @DisplayName("Buscando candidato por nome")
    void findByName() {
        Candidate candidate = CreateCandidate();

        Mockito.when(repository.findByNameLike(candidate.getName()))
                .thenReturn(Optional.of(CreateCandidate()));


        Optional<Candidate> candidateExists =
                service.findByName(candidate.getName());

        Assertions.assertThat(candidateExists).isPresent();
        Assertions.assertThat(candidateExists.get().getName()).isEqualTo("Pablo");
        Assertions.assertThat(candidateExists.get().getCpf()).isEqualTo("44951360988");
        Assertions.assertThat(candidateExists.get().getEmail()).isEqualTo("Pabloa@Fiap.com.br");
        Assertions.assertThat(candidateExists.get().getTelephone()).isEqualTo(32321388);
        Assertions.assertThat(candidateExists.get().getGender()).isEqualTo(Gender.Masculino);
        Assertions.assertThat(candidateExists.get().getBirth()).isEqualTo(CreateCandidate().getBirth());
    }


    @Test
    @DisplayName("Buscando candidato por e-mail")
    void findByEmail() {
        Candidate candidate = CreateCandidate();

        Mockito.when(repository.findByEmail(candidate.getEmail()))
                .thenReturn(Optional.of(CreateCandidate()));


        Optional<Candidate> candidateExists = service.findByEmail(candidate.getEmail());

        Assertions.assertThat(candidateExists).isPresent();
        Assertions.assertThat(candidateExists.get().getName()).isEqualTo("Pablo");
        Assertions.assertThat(candidateExists.get().getCpf()).isEqualTo("44951360988");
        Assertions.assertThat(candidateExists.get().getEmail()).isEqualTo("Pabloa@Fiap.com.br");
        Assertions.assertThat(candidateExists.get().getTelephone()).isEqualTo(32321388);
        Assertions.assertThat(candidateExists.get().getGender()).isEqualTo(Gender.Masculino);
        Assertions.assertThat(candidateExists.get().getBirth()).isEqualTo(CreateCandidate().getBirth());
    }

    @Test
    @DisplayName("Buscando candidato por cpf")
    void findByCpf() {
        Candidate candidate = CreateCandidate();

        Mockito.when(repository.findByCpf(candidate.getCpf()))
                .thenReturn(Optional.of(CreateCandidate()));


        Optional<Candidate> candidateExists = service.findByCpf(candidate.getCpf());

        Assertions.assertThat(candidateExists).isPresent();
        Assertions.assertThat(candidateExists.get().getName()).isEqualTo("Pablo");
        Assertions.assertThat(candidateExists.get().getCpf()).isEqualTo("44951360988");
        Assertions.assertThat(candidateExists.get().getEmail()).isEqualTo("Pabloa@Fiap.com.br");
        Assertions.assertThat(candidateExists.get().getTelephone()).isEqualTo(32321388);
        Assertions.assertThat(candidateExists.get().getGender()).isEqualTo(Gender.Masculino);
        Assertions.assertThat(candidateExists.get().getBirth()).isEqualTo(CreateCandidate().getBirth());
    }

    @Test
    @DisplayName("Deve lançar um erro customizado NotFound caso o candidato retorne null  na busca por nome")
    void findByNameError() {
        Candidate candidate = CreateCandidate();

        Mockito.when(repository.findByNameLike(Mockito.anyString()))
                .thenReturn(Optional.empty());

        Throwable exception = Assertions.catchThrowable(
                () -> service.findByName(null));

        Assertions.assertThat(exception)
                .isInstanceOf(CandidateNotFoundException.class).info.descriptionText()
                .equals("Candidato não encontrado, poderia por gentileza verificar as informações.");

        Mockito.verify(repository, Mockito.never()).findByNameLike(Mockito.anyString());
    }

    @Test
    @DisplayName("Deve lançar um erro customizado NotFound caso o candidato retorne null na busca por email")
    void findByEmailError() {
        Candidate candidate = CreateCandidate();

        Mockito.when(repository.findByEmail(Mockito.anyString()))
                .thenReturn(Optional.empty());

        Throwable exception = Assertions.catchThrowable(
                () -> service.findByEmail(null));

        Assertions.assertThat(exception)
                .isInstanceOf(CandidateNotFoundException.class).info.descriptionText()
                .equals("Candidato não encontrado, poderia por gentileza verificar as informações.");

        Mockito.verify(repository, Mockito.never()).findByNameLike(Mockito.anyString());

    }


    @Test
    @DisplayName("Deve lançar um erro customizado NotFound caso o candidato retorne null na busca por cpf")
    void findByCpfError() {
        Candidate candidate = CreateCandidate();

        Mockito.when(repository.findByCpf(Mockito.anyString()))
                .thenReturn(Optional.empty());

        Throwable exception = Assertions.catchThrowable(
                () -> service.findByCpf(null));

        Assertions.assertThat(exception)
                .isInstanceOf(CandidateNotFoundException.class).info.descriptionText()
                .equals("Candidato não encontrado, poderia por gentileza verificar as informações.");
    }
}

