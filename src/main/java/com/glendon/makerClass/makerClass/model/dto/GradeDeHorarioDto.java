package com.glendon.makerClass.makerClass.model.dto;

import com.glendon.makerClass.makerClass.model.entity.Alocacao;
import com.glendon.makerClass.makerClass.model.entity.Turma;
import com.glendon.makerClass.makerClass.model.enumerate.Turno;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GradeDeHorarioDto {
    private Long id;

    @NotNull(message = "A turma não pode ser nula")
    private Turma turma;

    @NotNull(message = "O turno não pode ser nulo")
    private Turno turno;

    @NotEmpty(message = "A lista de alocações não pode estar vazia")
    private List<Alocacao> alocacoes;
}