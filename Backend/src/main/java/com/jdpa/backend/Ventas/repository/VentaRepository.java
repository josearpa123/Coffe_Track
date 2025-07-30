package com.jdpa.backend.Ventas.repository;

import com.jdpa.backend.Ventas.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar ventas por fecha, cliente, etc.
    // Venta findByFecha(Date fecha);
    // List<Venta> findByCliente(Cliente cliente);
}
