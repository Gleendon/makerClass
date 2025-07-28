package com.glendon.makerClass.makerClass.pli;

import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PliService {

    public PliResponse solve(PliRequest request) {
        Loader.loadNativeLibraries();
        MPSolver solver = MPSolver.createSolver("SCIP");

        // 1. Variáveis de Decisão: x_ijtk
        Map<String, MPVariable> x = new HashMap<>();
        for (Long i : request.getProfessoresIds()) {
            for (Long j : request.getDisciplinasIds()) {
                for (Long t : request.getTurmasIds()) {
                    for (Long k : request.getHorariosIds()) {
                        String key = String.join("-", i.toString(), j.toString(), t.toString(), k.toString());
                        x.put(key, solver.makeBoolVar(key));
                    }
                }
            }
        }

        // 2. Função Objetivo: Maximizar a satisfação
        MPObjective objective = solver.objective();
        for (Map.Entry<String, MPVariable> entry : x.entrySet()) {
            String[] parts = entry.getKey().split("-");
            Long professorId = Long.parseLong(parts[0]);
            Long disciplinaId = Long.parseLong(parts[1]);
            String satisfacaoKey = professorId + "-" + disciplinaId;
            double satisfacao = request.getSatisfacaoProfessorDisciplina().getOrDefault(satisfacaoKey, 0.0);
            objective.setCoefficient(entry.getValue(), satisfacao);
        }
        objective.setMaximization();

        // 3. Restrições
        // Adicionar todas as 6 restrições aqui, conforme o modelo...

        // Exemplo: Restrição de Carga Horária da Turma por Disciplina
        for (Long t : request.getTurmasIds()) {
            for (Long j : request.getDisciplinasIds()) {
                String reqKey = j + "-" + t;
                int requiredSlots = request.getRequerimentoDisciplinaTurma().getOrDefault(reqKey, 0);
                if (requiredSlots > 0) {
                    MPConstraint constraint = solver.makeConstraint(requiredSlots, requiredSlots, "CargaHoraria_T" + t + "_D" + j);
                    for (Long i : request.getProfessoresIds()) {
                        for (Long k : request.getHorariosIds()) {
                            String varKey = String.join("-", i.toString(), j.toString(), t.toString(), k.toString());
                            constraint.setCoefficient(x.get(varKey), 1);
                        }
                    }
                }
            }
        }

        // ... Implementar as outras 5 restrições ...


        // 4. Resolver o problema
        final MPSolver.ResultStatus resultStatus = solver.solve();

        // 5. Montar a resposta
        PliResponse response = new PliResponse();
        if (resultStatus == MPSolver.ResultStatus.OPTIMAL || resultStatus == MPSolver.ResultStatus.FEASIBLE) {
            response.setStatus("Solução ótima encontrada.");
            response.setSatisfacaoTotal(objective.value());
            List<PliResponse.AlocacaoDetalhe> alocacoes = new ArrayList<>();
            for (Map.Entry<String, MPVariable> entry : x.entrySet()) {
                if (entry.getValue().solutionValue() == 1) {
                    String[] parts = entry.getKey().split("-");
                    PliResponse.AlocacaoDetalhe detalhe = new PliResponse.AlocacaoDetalhe();
                    detalhe.setProfessorId(Long.parseLong(parts[0]));
                    detalhe.setDisciplinaId(Long.parseLong(parts[1]));
                    detalhe.setTurmaId(Long.parseLong(parts[2]));
                    detalhe.setHorarioId(Long.parseLong(parts[3]));
                    alocacoes.add(detalhe);
                }
            }
            response.setAlocacoes(alocacoes);
        } else {
            response.setStatus("Não foi possível encontrar uma solução ótima.");
        }

        return response;
    }
}