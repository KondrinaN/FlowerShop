package com.accenture.flowershop.be.entity.user;

public class Customer extends User {
    private String surname, name, patronymic, address, phone;
    private double cashBalance;
    private int discount;

    public Customer(String login, String password, String surname, String name, String patronymic, String address, String phone, double cashBalance, int discount)
    {
        super(login, password);
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
        this.cashBalance = cashBalance;
        this.discount = discount;
    }


}
