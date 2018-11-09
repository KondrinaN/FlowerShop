package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.dto.CustomerDTO;
import com.accenture.flowershop.fe.enums.customer.UserShop;

import java.math.BigDecimal;

public interface UserBusinessService {

    void DeleteUserInMap(String loginUser);
    Customer logIn(String user, String password) throws Exception;
    Customer register(String login, String password, String surname, String name, String patronymic, String address, BigDecimal cashBalance, BigDecimal discount, UserShop userRole) throws Exception;
    boolean checkPassword(String passwordCurrent, String passwordCustomer);
    Customer updateCashBalance(Customer customer, BigDecimal cash) throws Exception;
}
