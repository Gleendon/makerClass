package com.glendon.makerClass.makerClass.model.dto;

import com.glendon.makerClass.makerClass.model.enumerate.Turno;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Year;
import java.util.List;

@Getter
@Setter
public class TurmaDto {
    private Long id;

    @NotBlank(message = "O nome da turma não pode estar em branco")
    private String nome;

    @NotNull(message = "O turno não pode ser nulo")
    private Turno turno;

    @NotNull(message = "O ano letivo não pode ser nulo")
    private Year anoLetivo;

    private List<Long> disciplinasIds;
}