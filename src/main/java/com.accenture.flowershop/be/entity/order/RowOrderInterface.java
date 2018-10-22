package com.accenture.flowershop.be.entity.order;

public interface RowOrderInterface {

    public void SetIdRowOrder(int id);
    public int GetIdRowOrder();

    public void SetIdOrder(int orderId);
    public int GetIdOrder();

    public void SetNameProduct(String nameProduct);
    public String GetNameProduct();

    public void SetCount(int count);
    public int GetCount();

    public void SetPrice(int price);
    public int GetPrice();
}
