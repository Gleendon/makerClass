package com.glendon.makerClass.makerClass.model.dto;

import com.glendon.makerClass.makerClass.model.entity.Turma;
import com.glendon.makerClass.makerClass.model.enumerate.TipoDisciplina;
import com.glendon.makerClass.makerClass.model.enumerate.Turno;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DisciplinaDto {
    private String nome;
    private String codigo;
    private Integer preferencia; // TODO: Pensar em como fazer isso
    private Float cargaHoraria;
    private TipoDisciplina tipoDisciplina;
    private List<Turno> turnos;
    private List<Turma> turmas; // TODO: avaliar a necessidade
}

