package com.usabb.models;

public class Product {
    private String name;
    private String code;
    private boolean stock;
    private Double price;
    private int quantity;
    private String delivery;
    private Double totalPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean getStock() {
        return stock;
    }

    public void setStock(String stock) {
        if (stock.equalsIgnoreCase("In Stock")) this.stock = true;
        else this.stock = false;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = getClearPrice(price);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = Integer.valueOf(quantity);
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = getClearPrice(totalPrice);
    }

    private double getClearPrice(String price) {
        return Double.valueOf(price.replaceAll("[^.0-9]", ""));
    }
}
