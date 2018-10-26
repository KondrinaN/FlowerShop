package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.user.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDAOImpl")
public class UserDAOImpl implements UserDAO{


    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findCustomerById() {
        return null;
    }

    @Override
    public Customer findCustomerByLogin() {
        return null;
    }

    @Override
    public int save() {
        return 0;
    }

}
