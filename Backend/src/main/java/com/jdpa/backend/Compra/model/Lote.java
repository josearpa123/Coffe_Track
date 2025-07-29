package com.jdpa.backend.Compra.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lotes")
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private String calidad;
    private String ubicacion;
    private String humedad;
    private String observaciones;

    public Lote() {}

    public Lote(LocalDate fecha, String calidad, String ubicacion, String humedad, String observaciones) {
        this.fecha = fecha;
        this.calidad = calidad;
        this.ubicacion = ubicacion;
        this.humedad = humedad;
        this.observaciones = observaciones;
    }

    // Getters y Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }

    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getCalidad() { return calidad; }

    public void setCalidad(String calidad) { this.calidad = calidad; }

    public String getUbicacion() { return ubicacion; }

    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public String getHumedad() { return humedad; }

    public void setHumedad(String humedad) { this.humedad = humedad; }

    public String getObservaciones() { return observaciones; }

    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}

