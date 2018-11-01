package com.accenture.flowershop.be.entity.flower;

import com.accenture.flowershop.fe.enums.flower.FlowerAvailability;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Flowers")
@NamedQueries(
        {
                @NamedQuery(name = "Flowers.findAll",
                        query = "SELECT f FROM Flower f"),
                @NamedQuery(name = "Flowers.findFlowerByName",
                        query = "SELECT f FROM Flower f WHERE f.nameFlower = :nameFlower"),
                @NamedQuery(name = "Flowers.findFlowerByRangePrice",
                        query = "SELECT f FROM Flower f WHERE f.price>=minPrice and f.price<=maxPrice"),
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

    @Column(name = "FlowerAvailability")
    private FlowerAvailability flowerAvailability;

    public Flower(){}

    public Flower(String nameFlower, BigDecimal balance, BigDecimal price, FlowerAvailability flowerAvailability)
    {
        this.nameFlower = nameFlower;
        this.balance = balance;
        this.price = price;
        this.flowerAvailability = flowerAvailability;
    }


    public Long getIdFlower() {
        return idFlower;
    }

    public void setIdFlower(Long idFlower) {
        this.idFlower = idFlower;
    }

    public FlowerAvailability getFlowerAvailability() {
        return flowerAvailability;
    }

    public void setFlowerAvailability(FlowerAvailability flowerAvailability) {
        this.flowerAvailability = flowerAvailability;
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
