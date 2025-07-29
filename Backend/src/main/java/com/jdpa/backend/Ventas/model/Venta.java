package com.jdpa.backend.Ventas.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import com.jdpa.backend.Ventas.model.Cliente;
import com.jdpa.backend.Compra.model.Inventario;
import com.jdpa.backend.usuario.model.Usuarios;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private LocalDate fecha;

    @Column(name = "cantidad_kg")
    private Double cantidadKg;

    @Column(name = "precio_kg")
    private Double precioKg;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "inventario_id")
    private Inventario inventario;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public Venta() {}

    public Venta(String tipo, LocalDate fecha, Double cantidadKg, Double precioKg, Cliente cliente, Inventario inventario, Usuarios usuario) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.cantidadKg = cantidadKg;
        this.precioKg = precioKg;
        this.cliente = cliente;
        this.inventario = inventario;
        this.usuario = usuario;
    }

    // Getters y Setters...
}
