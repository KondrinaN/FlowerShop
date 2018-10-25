package com.accenture.flowershop.be.entity.order;

import java.util.Date;

public interface OrderInterface {
    public void setIdOrder(int id);
    public int getIdOrder();

    public void setUsersId(int users_Id);
    public int getUsersId();

    public void setStatus(String status);
    public String getStatus();

    public void setAmount(int amount);
    public int getAmount();

    public void setDateCreate(Date dateCreate);
    public Date getDateCreate();

    public void setDateClose(Date dateClose);
    public Date getDateClose();
}
