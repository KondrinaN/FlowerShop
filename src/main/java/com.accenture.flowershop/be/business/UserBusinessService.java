package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.user.Customer;

public interface UserBusinessService {

    String logIn(String user, String password);
    Customer register(String login, String password, String surname, String name, String patronymic, String address, double cashBalance, int discount);
    Customer saveUser(Customer customer);
    int findIdUser(String login);
}
