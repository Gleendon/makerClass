package com.glendon.makerClass.makerClass.pli;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class PliRequest {

    // 1. Conjuntos
    private List<Long> professoresIds; // I: Conjunto de professores
    private List<Long> turmasIds;      // T: Conjunto de turmas
    private List<Long> disciplinasIds; // J: Conjunto de disciplinas
    private List<Long> horariosIds;    // K: Conjunto de slots de horário

    // 2. Parâmetros
    // s_ij: Grau de satisfação do professor i ao lecionar a disciplina j
    private Map<String, Double> satisfacaoProfessorDisciplina; // Chave: "professorId-disciplinaId"

    // d_ik: Disponibilidade do professor i no horário k
    private Map<String, Boolean> disponibilidadeProfessorHorario; // Chave: "professorId-horarioId"

    // req_tj: Número de slots de horário que a disciplina j requer na turma t
    private Map<String, Integer> requerimentoDisciplinaTurma; // Chave: "disciplinaId-turmaId"

    // a_i: Número máximo de aulas (slots) que o professor i pode lecionar
    private Map<Long, Integer> maxAulasProfessor; // Chave: professorId

    // compat_jk: Capacidade da disciplina j no horário k
    private Map<String, Boolean> compatibilidadeDisciplinaHorario; // Chave: "disciplinaId-horarioId"

    // q_ij: Capacidade do professor i lecionar a disciplina j
    private Map<String, Boolean> qualificacaoProfessorDisciplina; // Chave: "professorId-disciplinaId"
}