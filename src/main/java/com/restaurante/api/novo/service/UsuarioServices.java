package com.restaurante.api.novo.service;

import com.restaurante.api.novo.dto.request.LoginRequest;
import com.restaurante.api.novo.dto.request.RegistroRequest;
import com.restaurante.api.novo.model.UsuarioModel;
import com.restaurante.api.novo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioServices {

    private final UsuarioRepository repository;

    public UsuarioServices(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioModel> listaUsuario() {
        return repository.findAll();
    }

    public UsuarioModel buscarporId(Long id){

        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuario não encontrado"));
    }

    public UsuarioModel cadastrar(RegistroRequest dto) {

        UsuarioModel usuario = new UsuarioModel();

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
        usuario.setTipoUsuario(dto.tipoUsuario());
        usuario.setAtivo(true);

        return repository.save(usuario);
    }

    public UsuarioModel login(LoginRequest dto) {

        UsuarioModel usuario = repository.findByEmail(dto.email())
                .orElseThrow(() -> new RuntimeException("Email não encontrado"));

        if (!usuario.getSenha().equals(dto.senha())) {
            throw new RuntimeException("Senha incorreta");
        }
        return usuario;
    }

    public UsuarioModel alterar(Long id, RegistroRequest dto) {
        UsuarioModel usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
        usuario.setTipoUsuario(dto.tipoUsuario());

        return repository.save(usuario);
    }

    public UsuarioModel desativarUsuario(Long id) {
        UsuarioModel usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        usuario.setAtivo(false);

        return repository.save(usuario);
    }

    public UsuarioModel ativarUsuario(Long id) {
        UsuarioModel usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        usuario.setAtivo(true);

        return repository.save(usuario);
    }

    public void deletar(Long id) {
        UsuarioModel usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        repository.delete(usuario);
    }
}
