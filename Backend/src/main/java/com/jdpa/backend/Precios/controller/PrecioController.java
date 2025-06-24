package com.jdpa.backend.Precios.controller;

import com.jdpa.backend.Precios.dto.CrearPrecioDTO;
import com.jdpa.backend.Precios.dto.PrecioDTO;
import com.jdpa.backend.Precios.model.Precio;
import com.jdpa.backend.Precios.service.PrecioService;
import com.jdpa.backend.Precios.service.PrecioExternoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/precios")
@Tag(name = "Precios", description = "Operaciones relacionadas con precios locales e internacionales del café")
public class PrecioController {

    private final PrecioService precioService;
    private final PrecioExternoService externoService;

    public PrecioController(PrecioService precioService, PrecioExternoService externoService) {
        this.precioService = precioService;
        this.externoService = externoService;
    }

    @Operation(summary = "Guardar un nuevo precio", description = "Registra un nuevo precio con la fecha, precio local e internacional")
    @PostMapping
    public ResponseEntity<PrecioDTO> guardar(@RequestBody CrearPrecioDTO dto) {
        PrecioDTO creado = precioService.guardarPrecio(dto);
        return ResponseEntity.ok(creado);
    }

    @Operation(summary = "Listar todos los precios registrados")
    @GetMapping("/api/get_precios")
    public ResponseEntity<List<PrecioDTO>> listar() {
        return ResponseEntity.ok(precioService.listarPrecios());
    }

    @Operation(summary = "Buscar precio por fecha", description = "Obtiene el precio registrado en una fecha específica")
    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<PrecioDTO> buscarPorFecha(
            @Parameter(description = "Fecha en formato yyyy-MM-dd", example = "2025-06-23")
            @PathVariable String fecha) {
        return ResponseEntity.ok(precioService.buscarPrecioPorFecha(fecha));
    }

    @Operation(summary = "Obtener precio internacional actual", description = "Consulta el precio actual del café en dólares desde un proveedor externo")
    @GetMapping("/externo")
    public Mono<ResponseEntity<Double>> obtenerPrecioExterno() {
        return externoService.obtenerPrecioActualUsd()
                .map(ResponseEntity::ok);
    }

    @Operation(summary = "Obtener precio local por fecha", description = "Consulta el precio local del café para una fecha específica")
    @GetMapping("/local")
    public ResponseEntity<Double> obtenerPrecioLocalPorFecha(
            @Parameter(description = "Fecha en formato yyyy-MM-dd", example = "2025-06-23")
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        Optional<Precio> precioOpt = precioService.findByFecha(fecha);
        if (precioOpt.isPresent()) {
            return ResponseEntity.ok(precioOpt.get().getPrecioLocal());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

