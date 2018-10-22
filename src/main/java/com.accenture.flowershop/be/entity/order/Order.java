package com.accenture.flowershop.be.entity.order;

import javax.persistence.*;
import java.util.Date;

public class Order implements OrderInterface{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDERS_SEQ")
    @SequenceGenerator(name="ORDERS_SEQ", sequenceName = "ORDERS_SEQ", allocationSize = 1)
    private int idOrder;

    @OneToMany
    @JoinColumn(name = "IdUser")
    private int users_Id;

    @Column(name = "Status")
    private String status;

    @Column(name = "Amount")
    private int amount;

    @Column(name = "DateCreate")
    private Date dateCreate;

    @Column(name = "DateClose")
    private Date dateClose;

    public Order()
    {

    }

    @Override
    public void SetIdOrder(int id) {
        this.idOrder = id;
    }

    @Override
    public int GetIdOrder() {
        return idOrder;
    }

    @Override
    public void SetUsersId(int users_Id) {
        this.users_Id = users_Id;
    }

    @Override
    public int GetUsersId() {
        return users_Id;
    }

    @Override
    public void SetStatus(String status) {
        this.status = status;
    }

    @Override
    public String GetStatus() {
        return status;
    }

    @Override
    public void SetAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int GetAmount() {
        return amount;
    }

    @Override
    public void SetDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public Date GetDateCreate() {
        return dateCreate;
    }

    @Override
    public void SetDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }

    @Override
    public Date GetDateClose() {
        return dateClose;
    }
}
