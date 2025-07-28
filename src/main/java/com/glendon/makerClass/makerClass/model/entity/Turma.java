package com.glendon.makerClass.makerClass.model.entity;

import com.glendon.makerClass.makerClass.model.enumerate.Turno;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Year;
import java.util.List;

@Entity
@Getter
@Setter
public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Turno turno;
    private Year anoLetivo;
    private List<Disciplina> disciplinas;

}
