package com.jdpa.backend.Precios.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entidad que representa el precio del café en una fecha específica.
 * Incluye el precio local (obligatorio) y el precio internacional (opcional).
 */
@Entity
@Table(name = "precios")
public class Precio {

    /** Identificador único del registro de precio (clave primaria). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Fecha para la cual se registran los precios. Debe ser única. */
    @Column(nullable = false, unique = true)
    private LocalDate fecha;

    /** Precio local del café en la fecha indicada. */
    @Column(name = "precio_local", nullable = false)
    private Double precioLocal;

    /** Precio internacional del café en la fecha indicada. Puede ser nulo. */
    @Column(name = "precio_internacional")
    private Double precioInternacional;

    /** Constructor vacío requerido por JPA. */
    public Precio() {}

    /**
     * Constructor completo para crear una instancia de Precio.
     *
     * @param fecha               Fecha del precio.
     * @param precioLocal         Precio local del café.
     * @param precioInternacional Precio internacional del café.
     */
    public Precio(LocalDate fecha, Double precioLocal, Double precioInternacional) {
        this.fecha = fecha;
        this.precioLocal = precioLocal;
        this.precioInternacional = precioInternacional;
    }

    // Getters y setters

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
