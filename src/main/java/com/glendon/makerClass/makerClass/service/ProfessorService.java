package com.glendon.makerClass.makerClass.service;

import com.glendon.makerClass.makerClass.model.dto.ProfessorDto;
import com.glendon.makerClass.makerClass.model.entity.Disciplina;
import com.glendon.makerClass.makerClass.model.entity.Horario;
import com.glendon.makerClass.makerClass.model.entity.Professor;
import com.glendon.makerClass.makerClass.repository.DisciplinaRepository;
import com.glendon.makerClass.makerClass.repository.HorarioRepository;
import com.glendon.makerClass.makerClass.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final HorarioRepository horarioRepository;
    private final DisciplinaRepository disciplinaRepository;

    public ProfessorService(ProfessorRepository professorRepository,
                            HorarioRepository horarioRepository,
                            DisciplinaRepository disciplinaRepository) {
        this.professorRepository = professorRepository;
        this.horarioRepository = horarioRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    public Optional<Professor> buscarPorId(Long id) {
        return professorRepository.findById(id);
    }

    public Professor salvar(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor atualizar(Long id, ProfessorDto professorDTO) {
        return professorRepository.findById(id)
                .map(professorExistente -> {
                    // Converter IDs em objetos reais para salvar
                    List<Horario> horarios = horarioRepository.findAllById(professorDTO.getDisponibilidadeHorarioIds());
                    List<Disciplina> disciplinas = disciplinaRepository.findAllById(professorDTO.getPreferenciaDisciplinaIds());

                    professorExistente.setDisponibilidaDeHorario(horarios);
                    professorExistente.setPreferenciaDisciplina(disciplinas);

                    return professorRepository.save(professorExistente);
                })
                .orElseThrow(() -> new RuntimeException("Professor não encontrado!"));
    }

    public void deletar(Long id) {
        if (!professorRepository.existsById(id)) {
            throw new RuntimeException("Professor não encontrado!");
        }
        professorRepository.deleteById(id);
    }
}

