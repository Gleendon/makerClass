package com.glendon.makerClass.makerClass.model.dto;

import com.glendon.makerClass.makerClass.model.entity.Disciplina;
import com.glendon.makerClass.makerClass.model.entity.Professor;
import com.glendon.makerClass.makerClass.model.entity.Turma;
import com.glendon.makerClass.makerClass.model.enumerate.Turno;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@Setter
public class AlocacaoDto {
    private Long id;
    private Professor professor;
    private Disciplina disciplina;
    private Turma turma;
    private Turno turno;
    private DayOfWeek diaSemana;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;
}

