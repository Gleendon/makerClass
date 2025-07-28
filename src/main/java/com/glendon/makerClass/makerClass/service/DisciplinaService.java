package com.glendon.makerClass.makerClass.service;

import com.glendon.makerClass.makerClass.model.dto.DisciplinaDto;
import com.glendon.makerClass.makerClass.model.entity.Disciplina;
import com.glendon.makerClass.makerClass.repository.DisciplinaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Disciplina> listarTodas() {
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> buscarPorId(Long id) {
        return disciplinaRepository.findById(id);
    }

    public Disciplina salvar(DisciplinaDto disciplinaDto) {
        Disciplina disciplina = new Disciplina();
        BeanUtils.copyProperties(disciplinaDto, disciplina);
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina atualizar(Long id, DisciplinaDto disciplinaDto) {
        return disciplinaRepository.findById(id)
                .map(disciplinaExistente -> {
                    BeanUtils.copyProperties(disciplinaDto, disciplinaExistente, "id");
                    return disciplinaRepository.save(disciplinaExistente);
                })
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada!"));
    }

    public void deletar(Long id) {
        if (!disciplinaRepository.existsById(id)) {
            throw new RuntimeException("Disciplina não encontrada!");
        }
        disciplinaRepository.deleteById(id);
    }
}