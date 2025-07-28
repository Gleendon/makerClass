package com.glendon.makerClass.makerClass.model.entity;

import com.glendon.makerClass.makerClass.model.enumerate.Turno;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class GradeDeHorario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "turma_id", referencedColumnName = "id", unique = true)
    private Turma turma;

    @Enumerated(EnumType.STRING)
    private Turno turno;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "gradeDeHorario")
    private List<Alocacao> alocacoes;
}