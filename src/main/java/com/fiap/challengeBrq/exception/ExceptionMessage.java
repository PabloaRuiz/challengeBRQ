package com.fiap.challengeBrq.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExceptionMessage {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR", timezone = "UTC")
    @JsonProperty("Data")
    private LocalDateTime timestamp;

    @JsonProperty("Status")
    private Integer Code;

    @JsonProperty("Mensagem")
    private String message;
}
