package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.user.Customer;

import java.util.List;

public interface UserDAO {
    List<Customer> findAll();
    Customer findCustomerById(Long idUser);
    Customer findCustomerByLogin(String login);
    Long save(Customer customer);
}
