package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.order.RowOrder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface RowOrderBusinessService {
    void saveRowOrder(Order idOrder, List<RowOrder> rowOrders);
    List<RowOrder> findAllRowOrder(Long idOrder, Order order);
    void deleteRowOrder(int idOrder);
    public void OutRowOrders(HttpServletRequest request, List<Order> orders);
}
