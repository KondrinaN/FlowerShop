package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.UserDAOImpl;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.dto.CustomerDTO;
import com.accenture.flowershop.fe.enums.customer.UserShop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userBusinessService")
public class UserBusinessServiceImpl implements UserBusinessService{

    @Autowired
    private UserDAOImpl userDAO;

    private static final Logger LOG = 	LoggerFactory.getLogger(UserBusinessServiceImpl.class);

    public UserBusinessServiceImpl()
    {
       // LOG.debug("User");
        //System.out.println("userBusinessService");
    }

    @Override
    public String logIn(String user, String password) {

        return null;
    }

    @Override
    public Customer register(String login, String password, String surname, String name, String patronymic, String address, double cashBalance, int discount, UserShop userRole) {

        Customer customer = new Customer(login, password, surname, name, patronymic, address, cashBalance, discount, userRole);

        return customer;
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
