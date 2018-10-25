package com.accenture.flowershop.fe.dto;

import com.accenture.flowershop.be.access.FlowerDAO;

public class FlowerDTO {

    private int idFlower;
    private String nameFlower;
    private int balance;
    private double price;

    public FlowerDTO(){}

    public FlowerDTO(int idFlower, String nameFlower, int balance, double price) {
        this.idFlower = idFlower;
        this.nameFlower = nameFlower;
        this.balance = balance;
        this.price = price;
    }

    public int getIdFlower() {
        return idFlower;
    }

    public void setIdFlower(int idFlower) {
        this.idFlower = idFlower;
    }

    public String getNameFlower() {
        return nameFlower;
    }

    public void setNameFlower(String nameFlower) {
        this.nameFlower = nameFlower;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
