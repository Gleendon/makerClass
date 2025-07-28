package com.glendon.makerClass.makerClass.controller;

import com.glendon.makerClass.makerClass.dto.UsuarioDto;
import com.glendon.makerClass.makerClass.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getAllUsuarios() {
        List<UsuarioDto> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable Long id) {
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> createUsuario(@Valid @RequestBody UsuarioDto UsuarioDto) {
        try {
            UsuarioDto savedUsuario = usuarioService.create(UsuarioDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUsuario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null); // Exemplo de tratamento para email duplicado
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> updateUsuario(@PathVariable Long id, @Valid @RequestBody UsuarioDto UsuarioDto) {
        try {
            UsuarioDto updatedUsuario = usuarioService.update(id, UsuarioDto);
            return ResponseEntity.ok(updatedUsuario);
        } catch (RuntimeException e) {
            if (e.getMessage().contains("não encontrado")) {
                return ResponseEntity.notFound().build();
            } else if (e.getMessage().contains("Email já cadastrado")) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
            }
            return ResponseEntity.internalServerError().build(); // Outros erros inesperados
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        try {
            usuarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
