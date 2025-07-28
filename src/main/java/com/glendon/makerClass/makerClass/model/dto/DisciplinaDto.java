package com.glendon.makerClass.makerClass.model.dto;

import com.glendon.makerClass.makerClass.model.enumerate.TipoDisciplina;
import com.glendon.makerClass.makerClass.model.enumerate.Turno;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class DisciplinaDto {
    @NotBlank(message = "O nome da disciplina não pode estar em branco")
    @Size(max = 100, message = "O nome da disciplina deve ter no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "O código da disciplina não pode estar em branco")
    @Size(max = 20, message = "O código da disciplina deve ter no máximo 20 caracteres")
    private String codigo;

    private Integer preferencia;

    @NotNull(message = "A carga horária não pode ser nula")
    private Float cargaHoraria;

    @NotNull(message = "O tipo da disciplina não pode ser nulo")
    private TipoDisciplina tipoDisciplina;

    @NotEmpty(message = "A lista de turnos não pode estar vazia")
    private List<Turno> turnos;

    private List<Long> turmasIds;
}