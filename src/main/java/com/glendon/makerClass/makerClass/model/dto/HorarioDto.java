package com.glendon.makerClass.makerClass.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@Setter
public class HorarioDto {
    private Long id;

    @NotNull(message = "O dia da semana não pode ser nulo")
    private DayOfWeek diaDaSemana;

    @NotNull(message = "O horário de início não pode ser nulo")
    private LocalTime horarioInicio;

    @NotNull(message = "O horário de fim não pode ser nulo")
    private LocalTime horarioFim;
}