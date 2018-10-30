package com.accenture.flowershop.be.entity.order;

import com.accenture.flowershop.fe.enums.order.StatusOrder;

import java.util.Date;

public interface OrderInterface {
    public void setIdOrder(Long id);
    public Long getIdOrder();

    public void setUsersId(Long users_Id);
    public Long getUsersId();

    public void setStatus(StatusOrder status);
    public StatusOrder getStatus();

    public void setAmount(int amount);
    public int getAmount();

    public void setDateCreate(Date dateCreate);
    public Date getDateCreate();

    public void setDateClose(Date dateClose);
    public Date getDateClose();
}
