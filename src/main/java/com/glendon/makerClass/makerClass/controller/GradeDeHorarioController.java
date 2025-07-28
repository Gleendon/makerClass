package com.glendon.makerClass.makerClass.controller;

import com.glendon.makerClass.makerClass.model.dto.GradeDeHorarioDto;
import com.glendon.makerClass.makerClass.model.entity.GradeDeHorario;
import com.glendon.makerClass.makerClass.service.GradeDeHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades-horarios")
@CrossOrigin(origins = "*")
public class GradeDeHorarioController {

    @Autowired
    private GradeDeHorarioService gradeDeHorarioService;

    @GetMapping
    public ResponseEntity<List<GradeDeHorario>> listarTodos() {
        return ResponseEntity.ok(gradeDeHorarioService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeDeHorario> buscarPorId(@PathVariable Long id) {
        return gradeDeHorarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GradeDeHorario> cadastrar(@RequestBody GradeDeHorarioDto gradeDeHorarioDto) {
        return new ResponseEntity<>(gradeDeHorarioService.salvar(gradeDeHorarioDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            gradeDeHorarioService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}