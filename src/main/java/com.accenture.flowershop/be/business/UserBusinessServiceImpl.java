package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.UserDAO;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.enums.customer.UserShop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Customer logIn(String login, String password) throws Exception {
        //customers = userDAO.findAll();
        Customer customer = userDAO.findCustomerByLogin(login);

        if(customer!=null) {
            if (checkPassword(password, customer.getPassword()))
                return customer;
            else
                throw new Exception("Wrong password!");
        }
        else
            throw new Exception("User not registered!");

        /*if (users.size()!=0) {
            if (users.containsKey(login)) {

                return users.get(login);
            }
        }*/
    }

    @Override
    @Transactional
    public Customer register(String login, String password, String surname, String name, String patronymic, String address, BigDecimal cashBalance, BigDecimal discount, UserShop userRole)
            throws Exception{
        customers = userDAO.findAll();
        Customer customer = userDAO.findCustomerByLogin(login);

        if(customer==null)
        {
           customer= new Customer(login, password, surname, name, patronymic, address, cashBalance, discount, userRole);

           if (userDAO.save(customer)!=0)
               customers.add(customer);

           if (customer!=null)
               return customer;
           else
               throw new Exception("User not registered!");
        }
        else
            throw new Exception("User with this login is already registered!");

      /*  if (!users.containsKey(login)) {
            Customer customer = new Customer(login, password, surname, name, patronymic, address, cashBalance, discount, userRole);

            users.put(customer.getLogin(), customer);
            return customer;
        }*/
    }

    @Override
    public boolean checkPassword(String passwordCurrent, String passwordCustomer) {
        if(passwordCustomer.equals(passwordCurrent))
            return true;
        return false;
    }
}
