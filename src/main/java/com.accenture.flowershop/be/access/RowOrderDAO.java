package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.order.RowOrder;

import java.util.List;

public interface RowOrderDAO {
    List<RowOrder> findAll(Long idOrder, Order order);
    RowOrder findRowOrderById();
    boolean save(Order idOrder, List<RowOrder> orders);
    int update(int idOrder);
    int delete(int idOrder);
}
