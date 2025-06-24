package com.jdpa.backend.Precios.service;

import com.jdpa.backend.Precios.dto.CrearPrecioDTO;
import com.jdpa.backend.Precios.dto.PrecioDTO;
import com.jdpa.backend.Precios.model.Precio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Servicio que define las operaciones relacionadas con la gestión de precios.
 */
public interface PrecioService {

    /**
     * Guarda un nuevo precio local e internacional.
     *
     * @param dto Objeto DTO con los datos necesarios para crear el precio.
     * @return PrecioDTO con la información del precio guardado.
     */
    PrecioDTO guardarPrecio(CrearPrecioDTO dto);

    /**
     * Lista todos los precios registrados en el sistema.
     *
     * @return Lista de objetos PrecioDTO.
     */
    List<PrecioDTO> listarPrecios();

    /**
     * Busca un precio por su fecha en formato yyyy-MM-dd.
     *
     * @param fecha Fecha a buscar en formato String.
     * @return PrecioDTO con la información del precio encontrado.
     * @throws RuntimeException si no se encuentra un precio para esa fecha.
     */
    PrecioDTO buscarPrecioPorFecha(String fecha);

    /**
     * Busca un precio directamente como entidad `Precio` por fecha.
     * Usado generalmente para consultas más internas o sin necesidad de mapear a DTO.
     *
     * @param fecha Fecha a buscar.
     * @return Optional con la entidad Precio si existe.
     */
    Optional<Precio> findByFecha(LocalDate fecha);

}
