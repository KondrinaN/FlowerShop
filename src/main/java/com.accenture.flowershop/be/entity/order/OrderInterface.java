package com.accenture.flowershop.be.entity.order;

import java.util.Date;

public interface OrderInterface {
    public void SetIdOrder(int id);
    public int GetIdOrder();

    public void SetUsersId(int users_Id);
    public int GetUsersId();

    public void SetStatus(String status);
    public String GetStatus();

    public void SetAmount(int amount);
    public int GetAmount();

    public void SetDateCreate(Date dateCreate);
    public Date GetDateCreate();

    public void SetDateClose(Date dateClose);
    public Date GetDateClose();
}
