package com.accenture.flowershop.be.entity.order;

import java.util.List;

public interface RowOrderInterface {

    public void setIdRowOrder(Long id);
    public Long getIdRowOrder();

    public Order getOrderId();
    public void setOrderId(Order orderId);

    public void setNameProduct(String nameProduct);
    public String getNameProduct();

    public void setCount(int count);
    public int getCount();

    public void setPrice(int price);
    public int getPrice();
}
