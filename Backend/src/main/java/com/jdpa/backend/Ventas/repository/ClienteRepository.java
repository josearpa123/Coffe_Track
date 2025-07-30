package com.jdpa.backend.Ventas.repository;

import com.jdpa.backend.Ventas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar clientes por nombre, email, etc.
    Cliente findByNombre(String nombre);
    Cliente findByEmail(String email);
}
