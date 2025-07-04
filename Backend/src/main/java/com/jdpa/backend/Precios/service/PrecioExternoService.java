package com.jdpa.backend.Precios.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class PrecioExternoService {

    public String obtenerPrecioCafe() {
        // Ruta absoluta o relativa a tu ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/ruta/a/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Ejecuta sin abrir ventana del navegador
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(options);
        String resultado;

        try {
            driver.get("https://www.investing.com/commodities/us-coffee-c");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement priceElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("span[data-test='instrument-price-last']")
                    )
            );

            String precioTexto = priceElement.getText().replace(",", "").trim(); // Ej: "224.75"
            double precioUSDlb = Double.parseDouble(precioTexto);
            double precioUSDArroba = precioUSDlb * 25.3611;

            resultado = String.format("Precio en tiempo real del café: %.4f USD/lb (≈ %.2f USD/arroba)",
                    precioUSDlb, precioUSDArroba);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = "Error al obtener el precio en tiempo real: " + e.getMessage();
        } finally {
            driver.quit(); // Cierra el navegador
        }

        return resultado;
    }
}
// Nota: Asegúrate de tener el ChromeDriver compatible con tu versión de Chrome y que esté en la ruta especificada.