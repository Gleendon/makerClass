package com.glendon.makerClass.makerClass.service;

import com.glendon.makerClass.makerClass.model.entity.Diretor;
import com.glendon.makerClass.makerClass.repository.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiretorService {

    private final DiretorRepository diretorRepository;

    @Autowired
    public DiretorService(DiretorRepository diretorRepository) {
        this.diretorRepository = diretorRepository;
    }

    public List<Diretor> findAll() {
        return diretorRepository.findAll();
    }

    public Optional<Diretor> findById(Long id) {
        return diretorRepository.findById(id);
    }

    public Diretor save(Diretor diretor) {
        return diretorRepository.save(diretor);
    }

    public Diretor update(Long id, Diretor diretorDetails) {
        return diretorRepository.findById(id)
                .map(diretor -> {
                    // Atualiza os campos do Diretor (que herda de Usuario)
                    diretor.setNome(diretorDetails.getNome());
                    diretor.setEmail(diretorDetails.getEmail());
                    diretor.setSenha(diretorDetails.getSenha());
                    diretor.setCargo(diretorDetails.getCargo());
                    // Não atualizamos dataCadastro aqui, pois geralmente é definido na criação
                    return diretorRepository.save(diretor);
                })
                .orElseThrow(() -> new RuntimeException("Diretor não encontrado com o ID: " + id));
    }

    public void deleteById(Long id) {
        if (!diretorRepository.existsById(id)) {
            throw new RuntimeException("Diretor não encontrado com o ID: " + id);
        }
        diretorRepository.deleteById(id);
    }
}
