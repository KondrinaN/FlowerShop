package com.accenture.flowershop.be.entity.order;

import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.enums.order.StatusOrder;

import java.util.Date;

public interface OrderInterface {
    public void setIdOrder(Long id);
    public Long getIdOrder();

    public void setUsersId(Customer users_Id);
    public Customer getUsersId();

    public void setStatus(StatusOrder status);
    public StatusOrder getStatus();

    public void setAmount(int amount);
    public int getAmount();

    public void setDateCreate(Date dateCreate);
    public Date getDateCreate();

    public void setDateClose(Date dateClose);
    public Date getDateClose();
}
