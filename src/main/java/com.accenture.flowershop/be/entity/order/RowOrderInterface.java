package com.accenture.flowershop.be.entity.order;

public interface RowOrderInterface {

    public void setIdRowOrder(int id);
    public int getIdRowOrder();

    public void setIdOrder(int orderId);
    public int getIdOrder();

    public void setNameProduct(String nameProduct);
    public String getNameProduct();

    public void setCount(int count);
    public int getCount();

    public void setPrice(int price);
    public int getPrice();
}
