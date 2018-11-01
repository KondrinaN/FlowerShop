package com.accenture.flowershop.fe.dto;

import com.accenture.flowershop.be.access.FlowerDAO;
import com.accenture.flowershop.fe.enums.flower.FlowerAvailability;

public class FlowerDTO {

    private int idFlower;
    private String nameFlower;
    private int balance;
    private double price;
    private FlowerAvailability flowerAvailability;

    public FlowerDTO(){}


    public FlowerDTO(int idFlower, String nameFlower, int balance, double price, FlowerAvailability flowerAvailability) {
        this.idFlower = idFlower;
        this.nameFlower = nameFlower;
        this.balance = balance;
        this.price = price;
        this.flowerAvailability = flowerAvailability;
    }


    public FlowerAvailability getFlowerAvailability() {
        return flowerAvailability;
    }

    public void setFlowerAvailability(FlowerAvailability flowerAvailability) {
        this.flowerAvailability = flowerAvailability;
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
