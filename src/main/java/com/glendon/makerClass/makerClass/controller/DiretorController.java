package com.glendon.makerClass.makerClass.controller;

import com.glendon.makerClass.makerClass.model.entity.Diretor;
import com.glendon.makerClass.makerClass.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diretores")
public class DiretorController {

    private final DiretorService diretorService;

    @Autowired
    public DiretorController(DiretorService diretorService) {
        this.diretorService = diretorService;
    }

    @GetMapping
    public ResponseEntity<List<Diretor>> getAllDiretores() {
        List<Diretor> diretores = diretorService.findAll();
        return ResponseEntity.ok(diretores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diretor> getDiretorById(@PathVariable Long id) {
        return diretorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Diretor> createDiretor(@RequestBody Diretor diretor) {
        Diretor savedDiretor = diretorService.save(diretor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDiretor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Diretor> updateDiretor(@PathVariable Long id, @RequestBody Diretor diretor) {
        try {
            Diretor updatedDiretor = diretorService.update(id, diretor);
            return ResponseEntity.ok(updatedDiretor);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiretor(@PathVariable Long id) {
        try {
            diretorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
