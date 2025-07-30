package com.jdpa.backend.Compra.repository;

import com.jdpa.backend.Compra.model.Lote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface LoteRepository extends JpaRepository<Lote, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar lotes por fecha de producción, fecha de caducidad, etc.
    Lote findByFechaProduccion(Date fechaProduccion);
    Lote findByFechaCaducidad(Date fechaCaducidad);
}
