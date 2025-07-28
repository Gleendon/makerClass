package com.glendon.makerClass.makerClass.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Professor extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    private List<Horario> disponibilidaDeHorario;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "professor_preferencia_disciplina",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private List<Disciplina> preferenciaDisciplina;
}