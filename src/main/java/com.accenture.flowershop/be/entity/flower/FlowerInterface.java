package com.accenture.flowershop.be.entity.flower;

import java.math.BigDecimal;

public interface FlowerInterface {
    public void setId(Long id);
    public Long getId();

    public void setNameFlower(String nameFlower);
    public String getNameFlower();

    public void setBalance(BigDecimal balance);
    public BigDecimal getBalance();

    public void setPrice(BigDecimal price);
    public BigDecimal getPrice();
}
