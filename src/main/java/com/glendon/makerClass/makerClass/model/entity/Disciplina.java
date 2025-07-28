package com.glendon.makerClass.makerClass.model.entity;

import com.glendon.makerClass.makerClass.model.enumerate.TipoDisciplina;
import com.glendon.makerClass.makerClass.model.enumerate.Turno;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String codigo;
    private Float cargaHoraria;

    @Enumerated(EnumType.STRING)
    private TipoDisciplina tipoDisciplina;

    @ElementCollection(targetClass = Turno.class, fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "disciplina_turnos", joinColumns = @JoinColumn(name = "disciplina_id"))
    @Column(name = "turno")
    private List<Turno> turnos;

    @ManyToMany(mappedBy = "disciplinas", fetch = FetchType.LAZY)
    private List<Turma> turmas;
}