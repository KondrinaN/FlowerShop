package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.order.RowOrder;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.enums.order.StatusOrder;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

public interface OrderBusinessService {

    Order saveOrderCustomer(HttpServletRequest request);
    List<Order> findAllOrdersCustomer(HttpServletRequest request);
    Order findOrder(int idOrder);
    List<RowOrder> findRowOrder(int idOrder);
    void updateStatusOrder(Order order, StatusOrder statusOrder) throws Exception;
    void delete(int idOrder);
    List<Order> OutOrders(HttpServletRequest request);
    List<Order> OutOrdersAllAdmin(HttpServletRequest request);
    Order getOrderById(int id);
    List<Order> getOrders();
    void setOrders(List<Order> orders);
    int getLengthListOrders();
    BigDecimal getCashBalance(int numberPosition);
    Long getIdByNumberPosition(int numberPosition);
    List<Order> findAllOrdersAdmin(HttpServletRequest request);
}
