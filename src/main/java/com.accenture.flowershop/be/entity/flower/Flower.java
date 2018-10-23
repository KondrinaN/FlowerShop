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
    public void SetId(int id) {
        this.idFlower = id;
    }

    @Override
    public int GetId() {
        return idFlower;
    }

    @Override
    public void SetNameFlower(String nameFlower) {
        this.nameFlower = nameFlower;
    }

    @Override
    public String GetNameFlower() {
        return nameFlower;
    }

    @Override
    public void SetBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public int GetBalance() {
        return balance;
    }

    @Override
    public void SetPrice(int price) {
        this.price = price;
    }

    @Override
    public int GetPrice() {
        return price;
    }
}
