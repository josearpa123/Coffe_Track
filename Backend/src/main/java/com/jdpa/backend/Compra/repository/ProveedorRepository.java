package com.jdpa.backend.Compra.repository;

import com.jdpa.backend.Compra.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar proveedores por nombre o ubicación
    Proveedor findByNombre(String nombre);
    // Proveedor findByUbicacion(String ubicacion);

}
