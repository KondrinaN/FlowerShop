package com.accenture.flowershop.fe.dto;

public class RowOrderDTO {
    private int idRowOrder;
    private int orderId;
    private String nameProduct;
    private int count;
    private int price;

    public RowOrderDTO(){}

    public RowOrderDTO(int idRowOrder, int orderId, String nameProduct, int count, int price) {
        this.idRowOrder = idRowOrder;
        this.orderId = orderId;
        this.nameProduct = nameProduct;
        this.count = count;
        this.price = price;
    }

    public int getIdRowOrder() {
        return idRowOrder;
    }

    public void setIdRowOrder(int idRowOrder) {
        this.idRowOrder = idRowOrder;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
