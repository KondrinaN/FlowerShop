package com.accenture.flowershop.be.entity.flower;

import com.accenture.flowershop.fe.enums.flower.FlowerAvailability;

import java.math.BigDecimal;

public interface FlowerInterface {
    public Long getIdFlower();
    public void setIdFlower(Long idFlower);

    public FlowerAvailability getFlowerAvailability();
    public void setFlowerAvailability(FlowerAvailability flowerAvailability);

    public void setId(Long id);
    public Long getId();

    public void setNameFlower(String nameFlower);
    public String getNameFlower();

    public void setBalance(BigDecimal balance);
    public BigDecimal getBalance();

    public void setPrice(BigDecimal price);
    public BigDecimal getPrice();
}
