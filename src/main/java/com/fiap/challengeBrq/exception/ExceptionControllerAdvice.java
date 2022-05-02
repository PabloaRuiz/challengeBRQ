package com.fiap.challengeBrq.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;


@ControllerAdvice
public class ExceptionControllerAdvice {

    @ResponseBody
    @ExceptionHandler(CandidateNotFoundException.class)
    public ResponseEntity<ExceptionMessage> CandidateNotFound(CandidateNotFoundException e) {

        ExceptionMessage error = new ExceptionMessage(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
                "Candidato não encontrado, poderia por gentileza verificar as informações.");

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

}
