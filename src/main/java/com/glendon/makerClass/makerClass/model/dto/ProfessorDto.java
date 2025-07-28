package com.glendon.makerClass.makerClass.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ProfessorDto {
    @NotEmpty(message = "A lista de IDs de disponibilidade de horário não pode estar vazia.")
    private List<Long> disponibilidadeHorarioIds;

    @NotEmpty(message = "A lista de IDs de preferência de disciplina não pode estar vazia.")
    private List<Long> preferenciaDisciplinaIds;
}