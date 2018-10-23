package com.accenture.flowershop.be.entity.user;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class Customer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    @SequenceGenerator(name="USERS_SEQ", sequenceName = "USERS_SEQ", allocationSize = 1)
    private int idUser;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Name")
    private String name;

    @Column(name = "Patronymic")
    private String patronymic;

    @Column(name = "Address")
    private String address;

    @Column(name = "CashBalance")
    private double cashBalance;

    @Column(name = "Discount")
    private int discount;

    public Customer(String login, String password, String surname, String name, String patronymic, String address, double cashBalance, int discount)
    {
        super(login, password);
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.cashBalance = cashBalance;
        this.discount = discount;
    }


}
