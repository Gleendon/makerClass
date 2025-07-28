package com.glendon.makerClass.makerClass.model.entity;

import com.glendon.makerClass.makerClass.model.enumerate.Turno;
import jakarta.persistence.*;
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
    private Year anoLetivo;

    @Enumerated(EnumType.STRING)
    private Turno turno;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "turma_disciplinas",
            joinColumns = @JoinColumn(name = "turma_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private List<Disciplina> disciplinas;
}