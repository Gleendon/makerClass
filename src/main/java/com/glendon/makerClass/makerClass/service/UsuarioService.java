package com.glendon.makerClass.makerClass.service;

import com.glendon.makerClass.makerClass.dto.UsuarioDto;
import com.glendon.makerClass.makerClass.model.entity.Usuario;
import com.glendon.makerClass.makerClass.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDto> findAll() {
        return usuarioRepository.findAll().stream()
                .map(usuario -> {
                    UsuarioDto dto = new UsuarioDto();
                    dto.setId(usuario.getId());
                    dto.setNome(usuario.getNome());
                    dto.setEmail(usuario.getEmail());
                    dto.setCargo(usuario.getCargo());
                    dto.setDataCadastro(usuario.getDataCadastro());
                    dto.setSenha(null);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public Optional<UsuarioDto> findById(Long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    UsuarioDto dto = new UsuarioDto();
                    dto.setId(usuario.getId());
                    dto.setNome(usuario.getNome());
                    dto.setEmail(usuario.getEmail());
                    dto.setCargo(usuario.getCargo());
                    dto.setDataCadastro(usuario.getDataCadastro());
                    dto.setSenha(null);
                    return dto;
                });
    }

    public UsuarioDto create(UsuarioDto UsuarioDto) {
        if (usuarioRepository.findByEmail(UsuarioDto.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado: " + UsuarioDto.getEmail());
        }

        Usuario usuario = new Usuario();
        usuario.setNome(UsuarioDto.getNome());
        usuario.setEmail(UsuarioDto.getEmail());
        usuario.setSenha(UsuarioDto.getSenha());
        usuario.setCargo(UsuarioDto.getCargo());
        usuario.setDataCadastro(LocalTime.now());

        Usuario savedUsuario = usuarioRepository.save(usuario);

        UsuarioDto responseDTO = new UsuarioDto();
        responseDTO.setId(savedUsuario.getId());
        responseDTO.setNome(savedUsuario.getNome());
        responseDTO.setEmail(savedUsuario.getEmail());
        responseDTO.setCargo(savedUsuario.getCargo());
        responseDTO.setDataCadastro(savedUsuario.getDataCadastro());
        responseDTO.setSenha(null);
        return responseDTO;
    }

    public UsuarioDto update(Long id, UsuarioDto UsuarioDto) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    if (usuarioRepository.findByEmail(UsuarioDto.getEmail()).isPresent() && !UsuarioDto.getEmail().equals(usuario.getEmail())) {
                        throw new RuntimeException("Email já cadastrado por outro usuário: " + UsuarioDto.getEmail());
                    }

                    usuario.setNome(UsuarioDto.getNome());
                    usuario.setEmail(UsuarioDto.getEmail());

                    if (UsuarioDto.getSenha() != null && !UsuarioDto.getSenha().isEmpty()) {
                        usuario.setSenha(UsuarioDto.getSenha());
                    }

                    usuario.setCargo(UsuarioDto.getCargo());

                    Usuario updatedUsuario = usuarioRepository.save(usuario);
                    UsuarioDto responseDTO = new UsuarioDto();
                    responseDTO.setId(updatedUsuario.getId());
                    responseDTO.setNome(updatedUsuario.getNome());
                    responseDTO.setEmail(updatedUsuario.getEmail());
                    responseDTO.setCargo(updatedUsuario.getCargo());
                    responseDTO.setDataCadastro(updatedUsuario.getDataCadastro());
                    responseDTO.setSenha(null);
                    return responseDTO;
                })
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
    }

    public void deleteById(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado com o ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}