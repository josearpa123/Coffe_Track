package com.jdpa.backend.Precios.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "DTO que representa el precio del café para una fecha específica.")
public class PrecioDTO {

    @Schema(description = "ID único del precio", example = "1")
    private Long id;

    @Schema(description = "Fecha del precio", example = "2025-06-23")
    private LocalDate fecha;

    @Schema(description = "Precio local del café", example = "85000.0")
    private Double precioLocal;

    @Schema(description = "Precio internacional del café", example = "130.5")
    private Double precioInternacional;

    public PrecioDTO() {}

    public PrecioDTO(Long id, LocalDate fecha, Double precioLocal, Double precioInternacional) {
        this.id = id;
        this.fecha = fecha;
        this.precioLocal = precioLocal;
        this.precioInternacional = precioInternacional;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
