package com.jdpa.backend.Precios.service;

import com.jdpa.backend.Precios.external.PrecioFreaksResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Servicio que se encarga de consumir la API de APIFreaks para obtener
 * el precio internacional actual del café.
 */
@Service
public class PrecioExternoService {

    private final WebClient webClient;

    @Value("${api.key}")
    private String apiKey;

    public PrecioExternoService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://api.apifreaks.com/v1.0").build();
    }

    public Mono<Double> obtenerPrecioActualUsd() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/commodity/rates/latest")
                        .queryParam("apikey", apiKey)
                        .queryParam("symbols", "COFFEE")
                        .queryParam("updates", "1m")
                        .build())
                .retrieve()
                .bodyToMono(PrecioFreaksResponse.class)
                .map(PrecioFreaksResponse::getPrecioCafeUsd);
    }
}
