package com.jdpa.backend.Compra.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import com.jdpa.backend.usuario.model.Usuarios;
import com.jdpa.backend.Compra.model.Proveedor;
import com.jdpa.backend.Compra.model.Lote;

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private Double cantidadKg;
    private String tipo;
    private Double precioKg;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "lote_id")
    private Lote lote;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public Compra() {}

    public Compra(LocalDate fecha, Double cantidadKg, String tipo, Double precioKg, Proveedor proveedor, Lote lote, Usuarios usuario) {
        this.fecha = fecha;
        this.cantidadKg = cantidadKg;
        this.tipo = tipo;
        this.precioKg = precioKg;
        this.proveedor = proveedor;
        this.lote = lote;
        this.usuario = usuario;
    }

    // Getters y Setters...
}
