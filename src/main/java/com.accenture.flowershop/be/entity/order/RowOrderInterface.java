package com.accenture.flowershop.be.entity.order;

import java.math.BigDecimal;
import java.util.List;

public interface RowOrderInterface {

    public void setIdRowOrder(Long id);
    public Long getIdRowOrder();

    public Order getOrderId();
    public void setOrderId(Order orderId);

    public void setNameProduct(String nameProduct);
    public String getNameProduct();

    public void setCount(BigDecimal count);
    public BigDecimal getCount();

    public void setPrice(BigDecimal price);
    public BigDecimal getPrice();
    public String getPriceToString();
}
