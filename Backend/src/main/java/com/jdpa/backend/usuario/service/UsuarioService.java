package com.jdpa.backend.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdpa.backend.usuario.model.Usuarios;
import com.jdpa.backend.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuarios crearUsuario(String username, String password, String rol) {
        Usuarios usuario = new Usuarios(username, password, rol);
        return usuarioRepository.save(usuario);
    }
}
