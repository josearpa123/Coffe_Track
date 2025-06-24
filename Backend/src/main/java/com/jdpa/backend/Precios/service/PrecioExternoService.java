package com.jdpa.backend.Precios.service;

import com.jdpa.backend.Precios.external.PrecioNinjaResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Servicio que se encarga de consumir una API externa para obtener el precio
 * internacional actual del café.
 *
 * Esta implementación usa WebClient para hacer peticiones a la API de API Ninjas.
 * Requiere que la clave de API esté definida en el archivo de propiedades como:
 * <pre>
 * api.ninjas.key=TU_API_KEY
 * </pre>
 */
@Service
public class PrecioExternoService {

    private final WebClient webClient;

    @Value("${api.ninjas.key}")
    private String apiKey;

    /**
     * Constructor que configura el WebClient con la URL base de la API externa.
     *
     * @param builder WebClient.Builder inyectado por Spring para personalizar el cliente HTTP.
     */
    public PrecioExternoService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://api.api-ninjas.com/v1").build();
    }

    /**
     * Obtiene el precio internacional actual del café (commodity: coffee_c).
     *
     * @return Mono con el precio en formato Double.
     *         Lanza error si no se puede obtener la información o si la respuesta es vacía.
     */
    public Mono<Double> obtenerPrecioActualUsd() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/commodityprice")
                        .queryParam("name", "coffee_c")
                        .build())
                .header("X-Api-Key", apiKey)
                .retrieve()
                .bodyToMono(PrecioNinjaResponse[].class)
                .map(resultados -> resultados[0].getPrice()); // Asegúrate que resultados no esté vacío
    }
}

