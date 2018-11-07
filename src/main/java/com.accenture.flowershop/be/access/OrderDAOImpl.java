package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("orderDAOImpl")
public class OrderDAOImpl implements OrderDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> findAll(Customer customer) {
        try{
            TypedQuery<Order> query = entityManager.createNamedQuery("Orders.findAll", Order.class).setParameter("users_Id", customer);
            return query.getResultList();
        }
        catch (NoResultException exc)
        {
            return null;
        }
    }

    @Override
    public Order findOrderById() {
        return null;
    }

    @Override
    public Order findOrderByUser() {
        return null;
    }

    @Override
    public int save(int idOrder) {
        return 0;
    }

    @Override
    public int update(int idOrder) {
        return 0;
    }

    @Override
    public int delete(int idOrder) {
        return 0;
    }
}
