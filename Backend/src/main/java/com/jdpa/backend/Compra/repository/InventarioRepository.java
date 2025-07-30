package com.jdpa.backend.Compra.repository;

import com.jdpa.backend.Compra.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar inventarios por producto, cantidad, etc.
    Inventario findByProducto(String producto);
    // Inventario findByCantidad(int cantidad);
}
