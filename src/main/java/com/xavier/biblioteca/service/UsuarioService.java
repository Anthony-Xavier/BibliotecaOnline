package com.xavier.biblioteca.service;

import com.xavier.biblioteca.model.Emprestimo;
import com.xavier.biblioteca.model.Usuario;
import com.xavier.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private  UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome do usuário é obrigatório");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public void deletarUsuario(Long id) {
        Usuario usuario = buscarUsuarioPorId(id);
        usuarioRepository.delete(usuario);
    }

    public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
        Usuario usuario = buscarUsuarioPorId(id);
        usuario.setNome(usuarioDetails.getNome());
        return usuarioRepository.save(usuario);
    }

    public List<Emprestimo> listarEmprestimos(Long usuarioId) {
        Usuario usuario = buscarUsuarioPorId(usuarioId);
        return usuario.getEmprestimos();
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}
