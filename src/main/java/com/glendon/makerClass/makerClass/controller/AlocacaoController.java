package com.glendon.makerClass.makerClass.controller;

import com.glendon.makerClass.makerClass.model.dto.AlocacaoDto;
import com.glendon.makerClass.makerClass.model.entity.Alocacao;
import com.glendon.makerClass.makerClass.service.AlocacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alocacao")
@CrossOrigin(origins = "*")
public class AlocacaoController {

    private final AlocacaoService alocacaoService;

    public AlocacaoController(AlocacaoService alocacaoService) {
        this.alocacaoService = alocacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Alocacao>> listarTodos() {
        return ResponseEntity.ok(alocacaoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alocacao> buscarPorId(@PathVariable Long id) {
        return alocacaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alocacao> cadastrar(@RequestBody Alocacao alocacao) {
        return ResponseEntity.ok(alocacaoService.salvar(alocacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alocacao> atualizar(@PathVariable Long id, @RequestBody AlocacaoDto alocacaoDTO) {
        try {
            Alocacao alocacaoAtualizado = alocacaoService.atualizar(id, alocacaoDTO);
            return ResponseEntity.ok(alocacaoAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alocacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
