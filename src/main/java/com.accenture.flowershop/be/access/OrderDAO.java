package com.accenture.flowershop.be.access;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.user.Customer;

import java.util.List;

public interface OrderDAO {
    List<Order> findAll(Customer customer);
    Order findOrderById();
    Order findOrderByUser();
    int save(int idOrder);
    int update(int idOrder);
    int delete(int idOrder);
}
