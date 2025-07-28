package com.glendon.makerClass.makerClass.service;

import com.glendon.makerClass.makerClass.model.dto.TurmaDto;
import com.glendon.makerClass.makerClass.model.entity.Turma;
import com.glendon.makerClass.makerClass.repository.TurmaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public List<Turma> listarTodas() {
        return turmaRepository.findAll();
    }

    public Optional<Turma> buscarPorId(Long id) {
        return turmaRepository.findById(id);
    }

    public Turma salvar(TurmaDto turmaDto) {
        Turma turma = new Turma();
        BeanUtils.copyProperties(turmaDto, turma);
        return turmaRepository.save(turma);
    }

    public Turma atualizar(Long id, TurmaDto turmaDto) {
        return turmaRepository.findById(id)
                .map(turmaExistente -> {
                    BeanUtils.copyProperties(turmaDto, turmaExistente, "id");
                    return turmaRepository.save(turmaExistente);
                })
                .orElseThrow(() -> new RuntimeException("Turma não encontrada!"));
    }

    public void deletar(Long id) {
        if (!turmaRepository.existsById(id)) {
            throw new RuntimeException("Turma não encontrada!");
        }
        turmaRepository.deleteById(id);
    }
}