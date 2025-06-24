package com.jdpa.backend.Precios.repository;

import com.jdpa.backend.Precios.model.Precio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface PrecioRepository extends JpaRepository<Precio, Long> {

    Optional<Precio> findByFecha(LocalDate fecha);

    boolean existsByFecha(LocalDate fecha);


}
