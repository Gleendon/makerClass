package com.glendon.makerClass.makerClass.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@Setter
public class TurmaDto {
    private Long id;
    private DayOfWeek diaDaSemana;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;
}

