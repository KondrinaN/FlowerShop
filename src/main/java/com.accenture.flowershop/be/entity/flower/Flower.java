package com.accenture.flowershop.be.entity.flower;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Flowers")
public class Flower implements FlowerInterface{
    private int idFlower;
    private String nameFlower;
    private int balance;
    private int price;

    public Flower()
    {

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
    public int getPrice() {
        return price;
    }
}
