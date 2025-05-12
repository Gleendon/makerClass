package com.glendon.makerClass.makerClass.service;

import com.glendon.makerClass.makerClass.model.entity.Alocacao;
import com.glendon.makerClass.makerClass.repository.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class AlocacaoService {

    private final AlocacaoRepository alocacaoRepository;
    private final ProfessorRepository professorRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final TurmaRepository turmaRepository;


    public AlocacaoService(ProfessorRepository professorRepository, DisciplinaRepository disciplinaRepository,
                           TurmaRepository turmaRepository, AlocacaoRepository alocacaoRepository) {
        this.alocacaoRepository = alocacaoRepository;
        this.professorRepository = professorRepository;
        this.disciplinaRepository = disciplinaRepository;
        this.turmaRepository = turmaRepository;
    }

    public List<Alocacao> listarTodos() {
        return alocacaoRepository.findAll();
    }

    public Optional<Alocacao> buscarPorId(Long id) {
        return alocacaoRepository.findById(id);
    }

    public Alocacao salvar(Alocacao alocacao) {
        return alocacaoRepository.save(alocacao);
    }

    public Alocacao atualizar(Long id, Alocacao alocacao) {
        return alocacaoRepository.findById(id)
                .map(alocacaoExistente -> {
                    alocacaoExistente.setProfessor(professorRepository.findById(alocacao.getProfessor().getId()).get());
                    alocacaoExistente.setDisciplina(disciplinaRepository.findById(alocacao.getDisciplina().getId()).get());
                    alocacaoExistente.setTurma(turmaRepository.findById(alocacao.getTurma().getId()).get());
                    alocacaoExistente.setTurno(alocacao.getTurno());
                    alocacaoExistente.setDiaSemana(alocacao.getDiaSemana());
                    alocacaoExistente.setDiaSemana(alocacao.getDiaSemana());
                    alocacaoExistente.setHorarioInicio(alocacao.getHorarioInicio());
                    alocacaoExistente.setHorarioFim(alocacao.getHorarioFim());
                    return alocacaoRepository.save(alocacaoExistente);
                })
                .orElseThrow(() -> new RuntimeException("Alocação não encontrada!"));
    }

    public void deletar(Long id) {
        if (!alocacaoRepository.existsById(id)) {
            throw new RuntimeException("Alocação não encontrada!");
        }
        alocacaoRepository.deleteById(id);
    }

}
