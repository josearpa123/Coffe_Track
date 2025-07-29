package com.jdpa.backend.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jdpa.backend.usuario.model.Usuarios;
import com.jdpa.backend.usuario.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/crear")
    public Usuarios crearUsuario(@RequestBody Usuarios usuario) {
        return usuarioService.crearUsuario(usuario.getUsername(), usuario.getPasswordHash(), usuario.getRol());
    }
}
