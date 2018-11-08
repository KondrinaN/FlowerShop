package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.enums.order.StatusOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository("orderDAOImpl")
public class OrderDAOImpl implements OrderDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> findAllByUser_Id(Customer customer) {
        try{
            TypedQuery<Order> query = entityManager.createNamedQuery("Orders.findAllByUser_Id", Order.class).setParameter("users_Id", customer);
            return query.getResultList();
        }
        catch (NoResultException exc)
        {
            return null;
        }
    }

    @Override
    public List<Order> findAll() {
        try{
            TypedQuery<Order> query = entityManager.createNamedQuery("Orders.findAll", Order.class);
            List<Order> orders = query.getResultList();
            return orders;
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
    public int save(Long users_id, BigDecimal amount) {

     /*   HttpSession session = request.getSession();
        CustomerDTO customerDTO = (CustomerDTO)session.getAttribute("customer");
        if(customerDTO!=null) {
            Long users_id = customerDTO.getIdUser();
            BigDecimal amount = (BigDecimal)request.getAttribute("priceFull");

        Order order= new Order(users_id, StatusOrder.created, amount, new Date(), null)
        entityManager.persist(customer);
        return customer.getIdUser();*/
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
