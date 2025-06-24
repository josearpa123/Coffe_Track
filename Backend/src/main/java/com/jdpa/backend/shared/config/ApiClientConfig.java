package com.jdpa.backend.shared.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

public class ApiClientConfig {
    @Bean
    public WebClient commoditiesClient(@Value("${commodities-api.key}") String apiKey) {
        return WebClient.builder()
                .baseUrl("https://commodities-api.com/api")
                .defaultHeader("apikey", apiKey)
                .build();
    }
}
