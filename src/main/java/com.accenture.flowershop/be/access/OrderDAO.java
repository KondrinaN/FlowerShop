package com.accenture.flowershop.be.access;
import com.accenture.flowershop.be.entity.order.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> findAll();
    Order findOrderById();
    Order findOrderByUser();
    int save(int idOrder);
    int update(int idOrder);
    int delete(int idOrder);
}
