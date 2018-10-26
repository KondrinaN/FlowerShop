package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.dto.CustomerDTO;

public interface UserBusinessService {

    String logIn(String user, String password);
    Customer register(CustomerDTO customerDTO);
    Customer saveUser(Customer customer);
    int findIdUser(String login);
}
