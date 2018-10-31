package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
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
