package com.accenture.flowershop.fe.dto;

import com.accenture.flowershop.be.entity.user.Customer;

import java.util.Date;

public class OrderDTO {
    private Long idOrder;
    private Customer users_Id;
    private String status;
    private int amount;
    private Date dateCreate;
    private Date dateClose;

    public OrderDTO(){}

    public OrderDTO(Long idOrder, Customer users_Id, String status, int amount, Date dateCreate, Date dateClose) {
        this.idOrder = idOrder;
        this.users_Id = users_Id;
        this.status = status;
        this.amount = amount;
        this.dateCreate = dateCreate;
        this.dateClose = dateClose;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Customer getUsers_Id() {
        return users_Id;
    }

    public void setUsers_Id(Customer users_Id) {
        this.users_Id = users_Id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateClose() {
        return dateClose;
    }

    public void setDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }
}
