package com.jdpa.backend.Compra.repository;

import com.jdpa.backend.Compra.model.Secado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface SecadoRepository extends JpaRepository<Secado, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar secados por fecha, producto, etc.
    Secado findByFecha(Date fecha);
    Secado findByProducto(String producto);
}
