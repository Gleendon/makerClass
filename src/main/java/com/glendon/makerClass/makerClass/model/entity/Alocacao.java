package com.glendon.makerClass.makerClass.model.entity;

import com.glendon.makerClass.makerClass.model.enumerate.Turno;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class Alocacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Professor professor; // Professor responsável
    private Disciplina disciplina; // Disciplina que será lecionada
    private Turma turma; // Turma onde será ministrada a disciplina
    private Turno turno; // Turno em que a aula será realizada
    private DayOfWeek diaSemana; // Dia da semana da alocação (ex: Segunda-feira)
    private LocalTime horarioInicio; // Hora de início da aula
    private LocalTime horarioFim; // Hora de término da aula

    public Alocacao(Professor professor, Disciplina disciplina, Horario horario) {
        this.professor = professor;
        this.disciplina = disciplina;
        this.turma = turma;
        this.turno = turno;
        this.diaSemana = diaSemana;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }
}
