package com.jdpa.backend.Precios.service;

import com.jdpa.backend.Precios.dto.CrearPrecioDTO;
import com.jdpa.backend.Precios.dto.PrecioDTO;
import com.jdpa.backend.Precios.model.Precio;
import com.jdpa.backend.Precios.repository.PrecioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementación del servicio que gestiona la lógica de negocio relacionada con los precios del café.
 */
@Service
public class PrecioServiceImpl implements PrecioService {

    private final PrecioRepository precioRepository;

    public PrecioServiceImpl(PrecioRepository precioRepository) {
        this.precioRepository = precioRepository;
    }

    /**
     * Guarda un nuevo precio. Lanza excepción si ya existe uno para la fecha proporcionada.
     *
     * @param dto Objeto con los datos del nuevo precio.
     * @return PrecioDTO con los datos del precio creado.
     */
    @Override
    public PrecioDTO guardarPrecio(CrearPrecioDTO dto) {
        LocalDate fecha = dto.getFecha() != null ? dto.getFecha() : LocalDate.now();

        if (precioRepository.existsByFecha(fecha)) {
            throw new RuntimeException("Ya existe un precio registrado para la fecha: " + fecha);
        }

        Precio precio = new Precio(
                fecha,
                dto.getPrecioLocal(),
                dto.getPrecioInternacional()
        );

        Precio guardado = precioRepository.save(precio);

        return new PrecioDTO(
                guardado.getId(),
                guardado.getFecha(),
                guardado.getPrecioLocal(),
                guardado.getPrecioInternacional()
        );
    }

    /**
     * Retorna una lista de todos los precios registrados.
     *
     * @return Lista de PrecioDTO.
     */
    @Override
    public List<PrecioDTO> listarPrecios() {
        return precioRepository.findAll()
                .stream()
                .map(p -> new PrecioDTO(
                        p.getId(),
                        p.getFecha(),
                        p.getPrecioLocal(),
                        p.getPrecioInternacional()
                ))
                .collect(Collectors.toList());
    }

    /**
     * Busca un precio por una fecha específica.
     *
     * @param fechaStr Fecha en formato yyyy-MM-dd.
     * @return PrecioDTO correspondiente a la fecha.
     * @throws RuntimeException si no se encuentra un precio para esa fecha.
     */
    @Override
    public PrecioDTO buscarPrecioPorFecha(String fechaStr) {
        LocalDate fecha = LocalDate.parse(fechaStr);
        Optional<Precio> opt = precioRepository.findByFecha(fecha);

        return opt.map(p -> new PrecioDTO(
                p.getId(),
                p.getFecha(),
                p.getPrecioLocal(),
                p.getPrecioInternacional()
        )).orElseThrow(() -> new RuntimeException("No se encontró precio para la fecha: " + fechaStr));
    }

    /**
     * Devuelve un precio (opcional) directamente desde la base de datos según la fecha.
     *
     * @param fecha Fecha a consultar.
     * @return Optional de Precio.
     */
    @Override
    public Optional<Precio> findByFecha(LocalDate fecha) {
        return precioRepository.findByFecha(fecha);
    }

}
