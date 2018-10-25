package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.order.RowOrder;
import com.accenture.flowershop.be.entity.user.Customer;

import java.util.List;

public interface OrderBusinessService {

    void saveOrderCustomer(int idCustomer);
    List<Customer> findAllOrdersCustomer(int idCustomer);
    Order findOrder(int idOrder);
    List<RowOrder> findRowOrder(int idOrder);
    void update(int idOrder);
    void delete(int idOrder);
}
