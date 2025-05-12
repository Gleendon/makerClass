package com.glendon.makerClass.makerClass.model.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Professor extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Horario> disponibilidaDeHorario;
    private List<Disciplina> preferenciaDisciplina;

}
