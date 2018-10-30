package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.OrderDAO;
import com.accenture.flowershop.be.access.OrderDAOImpl;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.order.RowOrder;
import com.accenture.flowershop.be.entity.user.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderBusinessService")
public class OrderBusinessServiceImpl implements OrderBusinessService {

    @Autowired
    private OrderDAO orderDAO;

    private static final Logger LOG = 	LoggerFactory.getLogger(OrderBusinessServiceImpl.class);

    public OrderBusinessServiceImpl()
    {
        //LOG.debug("Order");
       // System.out.println("orderBusinessService");
    }

    @Override
    public void saveOrderCustomer(int idCustomer) {

    }

    @Override
    public List<Customer> findAllOrdersCustomer(int idCustomer) {
        return null;
    }

    @Override
    public Order findOrder(int idOrder) {
        return null;
    }

    @Override
    public List<RowOrder> findRowOrder(int idOrder) {
        return null;
    }

    @Override
    public void update(int idOrder) {

    }

    @Override
    public void delete(int idOrder) {

    }
}
