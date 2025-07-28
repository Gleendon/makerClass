package com.glendon.makerClass.makerClass.service;

import com.glendon.makerClass.makerClass.model.dto.GradeDeHorarioDto;
import com.glendon.makerClass.makerClass.model.entity.Alocacao;
import com.glendon.makerClass.makerClass.model.entity.GradeDeHorario;
import com.glendon.makerClass.makerClass.model.entity.Turma;
import com.glendon.makerClass.makerClass.repository.AlocacaoRepository;
import com.glendon.makerClass.makerClass.repository.GradeHorarioRepository;
import com.glendon.makerClass.makerClass.repository.TurmaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GradeDeHorarioService {

    @Autowired
    private GradeHorarioRepository gradeHorarioRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private AlocacaoRepository alocacaoRepository;

    public List<GradeDeHorario> listarTodas() {
        return gradeHorarioRepository.findAll();
    }

    public Optional<GradeDeHorario> buscarPorId(Long id) {
        return gradeHorarioRepository.findById(id);
    }

    public GradeDeHorario salvar(GradeDeHorarioDto gradeDeHorarioDto) {
        GradeDeHorario gradeDeHorario = new GradeDeHorario();

        Turma turma = turmaRepository.findById(gradeDeHorarioDto.getTurma().getId())
                .orElseThrow(() -> new RuntimeException("Turma não encontrada!"));
        gradeDeHorario.setTurma(turma);

        List<Alocacao> alocacoes = alocacaoRepository.findAllById(
                gradeDeHorarioDto.getAlocacoes().stream().map(Alocacao::getId).collect(Collectors.toList())
        );
        gradeDeHorario.setAlocacoes(alocacoes);

        BeanUtils.copyProperties(gradeDeHorarioDto, gradeDeHorario, "id", "turma", "alocacoes");
        return gradeHorarioRepository.save(gradeDeHorario);
    }

    public void deletar(Long id) {
        if (!gradeHorarioRepository.existsById(id)) {
            throw new RuntimeException("Grade de Horário não encontrada!");
        }
        gradeHorarioRepository.deleteById(id);
    }
}