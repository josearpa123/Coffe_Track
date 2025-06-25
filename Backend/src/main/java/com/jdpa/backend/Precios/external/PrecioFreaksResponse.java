package com.jdpa.backend.Precios.external;

public class PrecioFreaksResponse {
    private Data data;

    public Double getPrecioCafeUsd() {
        return (data != null && data.COFFEE != null) ? data.COFFEE.price : null;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        public Coffee COFFEE;

        public Coffee getCOFFEE() {
            return COFFEE;
        }

        public void setCOFFEE(Coffee COFFEE) {
            this.COFFEE = COFFEE;
        }
    }

    public static class Coffee {
        public double price;
        public String currency;

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }
}
