package com.glendon.makerClass.makerClass.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.glendon.makerClass.makerClass.model.enumerate.Cargo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiretorDto {

    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    @Size(max = 255, message = "O nome deve ter no máximo 255 caracteres")
    private String nome;

    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "O email deve ser válido")
    @Size(max = 255, message = "O email deve ter no máximo 255 caracteres")
    private String email;

    @NotBlank(message = "A senha não pode estar em branco")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    private String senha;

    @NotNull(message = "O cargo não pode ser nulo")
    private Cargo cargo;

    private LocalTime dataCadastro;
}

