package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.order.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderDAOImpl")
public class OrderDAOImpl implements OrderDAO {
    @Override
    public List<Order> findAll() {
        return null;
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
