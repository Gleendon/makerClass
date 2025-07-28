package com.glendon.makerClass.makerClass.model.dto;

import com.glendon.makerClass.makerClass.model.entity.Disciplina;
import com.glendon.makerClass.makerClass.model.entity.Professor;
import com.glendon.makerClass.makerClass.model.entity.Turma;
import com.glendon.makerClass.makerClass.model.enumerate.Turno;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@Setter
public class AlocacaoDto {
    private Long id;

    @NotNull(message = "O professor não pode ser nulo")
    private Professor professor;

    @NotNull(message = "A disciplina não pode ser nula")
    private Disciplina disciplina;

    @NotNull(message = "A turma não pode ser nula")
    private Turma turma;

    @NotNull(message = "O turno não pode ser nulo")
    private Turno turno;

    @NotNull(message = "O dia da semana não pode ser nulo")
    private DayOfWeek diaSemana;

    @NotNull(message = "O horário de início não pode ser nulo")
    private LocalTime horarioInicio;

    @NotNull(message = "O horário de fim não pode ser nulo")
    private LocalTime horarioFim;
}