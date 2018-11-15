package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.user.Customer;

import java.math.BigDecimal;
import java.util.List;

public interface UserDAO {
    List<Customer> findAll();
    Customer findCustomerById(Long idUser) throws Exception ;
    Customer findCustomerByLogin(String login) throws Exception ;
    Long save(Customer customer) throws Exception;
    Customer updateCashBalance(Customer customer, BigDecimal cash) throws Exception;
    void changeDiscount(Long idUser, BigDecimal discount);
}
