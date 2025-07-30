package com.jdpa.backend.Compra.repository;

import com.jdpa.backend.Compra.model.Compra;
import com.jdpa.backend.Compra.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar compras por fecha, proveedor, etc.
     Compra findByFecha(Date fecha);
     List<Compra> findByProveedor(Proveedor proveedor);
}
