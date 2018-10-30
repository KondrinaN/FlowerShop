package com.accenture.flowershop.be.entity.flower;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Flowers")
public class Flower implements FlowerInterface{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FLOWERS_SEQ")
    @SequenceGenerator(name="FLOWERS_SEQ", sequenceName = "FLOWERS_SEQ", allocationSize = 1)
    private Long idFlower;

    @Column(name = "NameFlower")
    private String nameFlower;

    @Column(name = "Balance")
    private BigDecimal balance;

    @Column(name = "Price")
    private BigDecimal price;

    public Flower(){}

    public Flower(Long idFlower, String nameFlower, BigDecimal balance, BigDecimal price)
    {
        this.idFlower = idFlower;
        this.nameFlower = nameFlower;
        this.balance = balance;
        this.price = price;
    }

    @Override
    public void setId(Long id) {
        this.idFlower = id;
    }

    @Override
    public Long getId() {
        return idFlower;
    }

    @Override
    public void setNameFlower(String nameFlower) {
        this.nameFlower = nameFlower;
    }

    @Override
    public String getNameFlower() {
        return nameFlower;
    }

    @Override
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
