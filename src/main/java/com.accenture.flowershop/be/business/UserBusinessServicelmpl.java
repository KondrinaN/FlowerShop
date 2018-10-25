package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.UserDAOlmpl;
import com.accenture.flowershop.be.entity.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userBusinessService")
public class UserBusinessServicelmpl implements UserBusinessService{

    @Autowired
    private UserDAOlmpl userDAO;

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
