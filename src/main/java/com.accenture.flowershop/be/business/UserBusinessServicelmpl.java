package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.UserDAO;
import com.accenture.flowershop.be.entity.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;

public class UserBusinessServicelmpl implements UserBusinessService{

    @Autowired
    protected UserDAO userDAO;

    @Override
    public String logIn(String user, String password) {

        return null;
    }

    @Override
    public Customer register(String login, String password, String surname, String name, String patronymic, String address, double cashBalance, int discount) {
        return null;
    }

    @Override
    public Customer saveUser(Customer customer) {
        return null;
    }

    @Override
    public int findIdUser(String login) {
        return 0;
    }
}
