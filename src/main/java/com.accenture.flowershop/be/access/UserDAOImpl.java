package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("userDAOImpl")
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        try{
            TypedQuery<Customer> query = entityManager.createNamedQuery("Users.findAll", Customer.class);
            List<Customer> users= query.getResultList();
            return  users;
        }
        catch (NoResultException exc)
        {}
        return null;
    }

    @Override
    public Customer findCustomerById() {
        return null;
    }

    @Override
    public Customer findCustomerByLogin(String login) {
        try{
            TypedQuery<Customer> query = entityManager.createNamedQuery("Users.findByLogin", Customer.class);
            query.setParameter("Login", login);
            return query.getSingleResult();
        }
        catch (NoResultException exc)
        {}
        return null;
    }


    @Override
    public int save() {
        return 0;
    }

}
