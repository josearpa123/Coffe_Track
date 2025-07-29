package com.jdpa.backend.Ventas.model;
import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String vereda;

    public Cliente() {}

    public Cliente(String nombre, String vereda) {
        this.nombre = nombre;
        this.vereda = vereda;
    }

    // Getters y Setters...
}
