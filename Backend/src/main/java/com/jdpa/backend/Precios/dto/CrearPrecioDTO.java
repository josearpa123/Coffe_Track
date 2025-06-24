package com.jdpa.backend.Precios.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

/**
 * DTO (Data Transfer Object) para la creación de un precio.
 * Este objeto encapsula los datos necesarios para registrar un precio local e internacional en una fecha específica.
 */
@Schema(description = " * DTO (Data Transfer Object) para la creación de un precio.\n" +
        " * Este objeto encapsula los datos necesarios para registrar un precio local e internacional en una fecha específica.")
public class CrearPrecioDTO {

    /**
     * Fecha en la que se registra el precio.
     */
    private LocalDate fecha;

    /**
     * Precio local ingresado manualmente.
     */
    private Double precioLocal;

    /**
     * Precio internacional obtenido de una API externa o ingresado manualmente.
     */
    private Double precioInternacional;

    /**
     * Constructor vacío necesario para la deserialización.
     */
    public CrearPrecioDTO() {}

    /**
     * Constructor para inicializar un objeto CrearPrecioDTO con todos sus campos.
     *
     * @param fecha               Fecha del precio.
     * @param precioLocal         Precio local.
     * @param precioInternacional Precio internacional.
     */
    public CrearPrecioDTO(LocalDate fecha, Double precioLocal, Double precioInternacional) {
        this.fecha = fecha;
        this.precioLocal = precioLocal;
        this.precioInternacional = precioInternacional;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getPrecioLocal() {
        return precioLocal;
    }

    public void setPrecioLocal(Double precioLocal) {
        this.precioLocal = precioLocal;
    }

    public Double getPrecioInternacional() {
        return precioInternacional;
    }

    public void setPrecioInternacional(Double precioInternacional) {
        this.precioInternacional = precioInternacional;
    }
}
