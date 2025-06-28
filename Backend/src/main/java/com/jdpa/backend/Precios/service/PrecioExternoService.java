package com.jdpa.backend.Precios.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class PrecioExternoService {

    public String obtenerPrecioCafe() {
        try {
            Document doc = Jsoup.connect("https://www.investing.com/commodities/us-coffee-c")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0 Safari/537.36")
                    .referrer("https://www.google.com")
                    .timeout(10000)
                    .get();

            // El precio está en una etiqueta <span> con clase "text-2xl"
            Element precioElement = doc.selectFirst("span[data-test='instrument-price-last']");

            if (precioElement != null) {
                String precioTexto = precioElement.text().replace(",", "").trim(); // Ej: "303.75"
                double precioCents = Double.parseDouble(precioTexto); // En centavos de dólar
                double precioUSDlb = precioCents / 100.0;
                double precioUSDArroba = precioUSDlb * 25.3611;

                return String.format("Precio actual del café: %.4f USD/lb (≈ %.2f USD/arroba)",
                        precioUSDlb, precioUSDArroba);
            } else {
                return "No se pudo encontrar el precio en Investing.com (verifica selector).";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al obtener el precio: " + e.getMessage();
        }
    }
}
