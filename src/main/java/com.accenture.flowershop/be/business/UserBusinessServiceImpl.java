package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.FlowerDAO;
import com.accenture.flowershop.be.access.UserDAO;
import com.accenture.flowershop.be.access.UserDAOImpl;
import com.accenture.flowershop.be.entity.flower.Flower;
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
    private UserDAO userDAO;


    private Map<String, Customer> users;
    private List<Customer> customers;

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
        customers = userDAO.findAll();


        Customer customer = userDAO.findCustomerByLogin(login);

        if(customer!=null)
           if (checkPassword(password, customer.getPassword()))
               return customer;

        /*if (users.size()!=0) {
            if (users.containsKey(login)) {

                return users.get(login);
            }
        }*/
        return null;
    }

    @Override
    public Customer register(String login, String password, String surname, String name, String patronymic, String address, BigDecimal cashBalance, BigDecimal discount, UserShop userRole) {
        if (!users.containsKey(login)) {
            Customer customer = new Customer(login, password, surname, name, patronymic, address, cashBalance, discount, userRole);

            users.put(customer.getLogin(), customer);
            return customer;
        }
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

    @Override
    public boolean checkPassword(String passwordCurrent, String passwordCustomer) {
        if(passwordCustomer.equals(passwordCurrent))
            return true;
        return false;
    }
}
