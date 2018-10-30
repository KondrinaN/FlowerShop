package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.UserDAOImpl;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.dto.CustomerDTO;
import com.accenture.flowershop.fe.enums.customer.UserShop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service("userBusinessService")
public class UserBusinessServiceImpl implements UserBusinessService{

    @Autowired
    private UserDAOImpl userDAO;

    private Map<String, Customer> users;

    private static final Logger LOG = 	LoggerFactory.getLogger(UserBusinessServiceImpl.class);

    public UserBusinessServiceImpl()
    {
        users = new HashMap<String, Customer>();
       // LOG.debug("User");
        //System.out.println("userBusinessService");
    }


    public void DeleteUserInMap(String loginUser)
    {
        for(Iterator<Map.Entry<String, Customer>> it = users.entrySet().iterator(); it.hasNext(); )
        {
            Map.Entry<String, Customer> entry = it.next();
            if(entry.getKey().equals(loginUser)) {
                it.remove();
            }
        }
    }

    @Override
    public Customer logIn(String login, String password) {
       Customer customer = new Customer(login, password);

       if (users== null)
           users = new HashMap<String, Customer>();

       users.put(login, customer);

        return customer;
    }

    @Override
    public Customer register(String login, String password, String surname, String name, String patronymic, String address, BigDecimal cashBalance, BigDecimal discount, UserShop userRole) {

        Customer customer = new Customer(login, password, surname, name, patronymic, address, cashBalance, discount, userRole);

        if (users== null)
            users = new HashMap<String, Customer>();

        users.put("customer", customer);
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
