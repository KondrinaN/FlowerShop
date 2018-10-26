package com.accenture.flowershop.be.entity.flower;

import javax.persistence.*;

@Entity
@Table(name = "Flowers")
public class Flower implements FlowerInterface{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FLOWERS_SEQ")
    @SequenceGenerator(name="FLOWERS_SEQ", sequenceName = "FLOWERS_SEQ", allocationSize = 1)
    private int idFlower;

    @Column(name = "NameFlower")
    private String nameFlower;

    @Column(name = "Balance")
    private int balance;

    @Column(name = "Price")
    private double price;

    public Flower(){}

    public Flower(int idFlower, String nameFlower, int balance, double price)
    {
        this.idFlower = idFlower;
        this.nameFlower = nameFlower;
        this.balance = balance;
        this.price = price;
    }

    @Override
    public void setId(int id) {
        this.idFlower = id;
    }

    @Override
    public int getId() {
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
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
