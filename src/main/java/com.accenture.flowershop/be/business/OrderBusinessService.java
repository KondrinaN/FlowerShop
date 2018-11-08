package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.order.RowOrder;
import com.accenture.flowershop.be.entity.user.Customer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface OrderBusinessService {

    void saveOrderCustomer(HttpServletRequest request);
    List<Order> findAllOrdersCustomer(HttpServletRequest request);
    Order findOrder(int idOrder);
    List<RowOrder> findRowOrder(int idOrder);
    void update(int idOrder);
    void delete(int idOrder);
    public List<Order> OutOrders(HttpServletRequest request);
    public Order getOrderById(int id);
    public List<Order> getOrders();
    public void setOrders(List<Order> orders);
    int getLengthListOrders();
    public Long getIdByNumberPosition(int numberPosition);
}
