package com.jdpa.backend.Compra.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import com.jdpa.backend.Compra.model.Lote;

@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    @Column(name = "cantidad_kg")
    private Double cantidadKg;

    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "lote_id")
    private Lote lote;

    public Inventario() {}

    public Inventario(String tipo, Double cantidadKg, LocalDate fechaIngreso, Lote lote) {
        this.tipo = tipo;
        this.cantidadKg = cantidadKg;
        this.fechaIngreso = fechaIngreso;
        this.lote = lote;
    }

    // Getters y Setters...
}
