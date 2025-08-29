package com.xavier.biblioteca.controller;

import com.xavier.biblioteca.model.Usuario;
import com.xavier.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }

    //Listar todos os usuários
    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    //Consultar usuário por ID
    @GetMapping("/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarUsuarioPorId(id);
    }

    //Atualizar usuário
    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usario) {
        return usuarioService.updateUsuario(id,usario);
    }

    //Deletar usuário
    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }

    //Listar empréstimos de um usuário
    @GetMapping("/{id}/emprestimos")
    public List listarEmprestimos(@PathVariable Long id) {
        return usuarioService.listarEmprestimos(id);
    }
}
