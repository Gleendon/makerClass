package com.glendon.makerClass.makerClass.service;

import com.glendon.makerClass.makerClass.model.entity.Horario;
import com.glendon.makerClass.makerClass.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public List<Horario> listarTodos() {
        return horarioRepository.findAll();
    }

    public Optional<Horario> buscarPorId(Long id) {
        return horarioRepository.findById(id);
    }

    public Horario salvar(Horario horario) {
        return horarioRepository.save(horario);
    }

    public void deletar(Long id) {
        if (!horarioRepository.existsById(id)) {
            throw new RuntimeException("Horário não encontrado!");
        }
        horarioRepository.deleteById(id);
    }
}