package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.math.BigDecimal;
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
            return users;
        }
        catch (NoResultException exc)
        {
            return null;
        }
    }

    @Override
    public Customer findCustomerById(Long idUser) {
        try{
            TypedQuery<Customer> query = entityManager.createNamedQuery("Users.findCustomerById", Customer.class).setParameter("idUser", idUser);
            return query.getSingleResult();
        }
        catch (NoResultException exc)
        {
            return null;
        }
    }

    @Override
    public Customer findCustomerByLogin(String login) {
        try{
            TypedQuery<Customer> query = entityManager.createNamedQuery("Users.findCustomerByLogin", Customer.class).setParameter("login", login);
            return query.getSingleResult();
        }
        catch (NoResultException exc)
        {
            return null;
        }
    }


    @Override

    public Long save(Customer customer) throws Exception{

        entityManager.persist(customer);
        return customer.getIdUser();

    }

}
