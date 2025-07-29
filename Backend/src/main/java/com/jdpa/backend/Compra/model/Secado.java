package com.jdpa.backend.Compra.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import com.jdpa.backend.Compra.model.Compra;
import com.jdpa.backend.usuario.model.Usuarios;

@Entity
@Table(name = "secado")
public class Secado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaSecado;
    private Double pesoSecado;
    private Double merma;

    @OneToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public Secado() {}

    public Secado(LocalDate fechaSecado, Double pesoSecado, Double merma, Compra compra, Usuarios usuario) {
        this.fechaSecado = fechaSecado;
        this.pesoSecado = pesoSecado;
        this.merma = merma;
        this.compra = compra;
        this.usuario = usuario;
    }

    // Getters y Setters...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaSecado() {
        return fechaSecado;
    }

    public void setFechaSecado(LocalDate fechaSecado) {
        this.fechaSecado = fechaSecado;
    }

    public Double getPesoSecado() {
        return pesoSecado;
    }

    public void setPesoSecado(Double pesoSecado) {
        this.pesoSecado = pesoSecado;
    }

    public Double getMerma() {
        return merma;
    }

    public void setMerma(Double merma) {
        this.merma = merma;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
