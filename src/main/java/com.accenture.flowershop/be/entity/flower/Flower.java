package com.accenture.flowershop.be.entity.flower;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Flowers")
@NamedQueries(
        {
                @NamedQuery(name = "Flowers.findAll",
                        query = "SELECT f FROM Flower f"),
        }
)
public class Flower implements FlowerInterface{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFlower;

    @Column(name = "NameFlower")
    private String nameFlower;

    @Column(name = "Balance")
    private BigDecimal balance;

    @Column(name = "Price")
    private BigDecimal price;

    public Flower(){}

    public Flower(String nameFlower, BigDecimal balance, BigDecimal price)
    {
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
