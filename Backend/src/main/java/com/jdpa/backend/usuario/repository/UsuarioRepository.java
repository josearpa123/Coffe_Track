package com.jdpa.backend.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jdpa.backend.usuario.model.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar usuarios por nombre de usuario o correo electrónico
    Usuarios findByUsername(String username);
    //Usuarios findByEmail(String email);

}
