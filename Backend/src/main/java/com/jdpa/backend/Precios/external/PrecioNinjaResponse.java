package com.jdpa.backend.Precios.external;

public class PrecioNinjaResponse {
    private String name;
    private String symbol;
    private double price;

    public PrecioNinjaResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
