package com.glendon.makerClass.makerClass.model.entity;

import com.glendon.makerClass.makerClass.model.enumerate.Cargo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "tb_usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = false, length = 255)
    private String senha;

    @Column(name = "data_cadastro")
    private LocalTime dataCadastro;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Cargo cargo;

}