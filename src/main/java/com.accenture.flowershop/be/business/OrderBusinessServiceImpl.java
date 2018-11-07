package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.OrderDAO;
import com.accenture.flowershop.be.access.OrderDAOImpl;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.order.RowOrder;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.dto.CustomerDTO;
import com.accenture.flowershop.fe.dto.RowOrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    public List<Order> findAllOrdersCustomer(HttpServletRequest request) {
        HttpSession session = request.getSession();
        CustomerDTO customerDTO = (CustomerDTO)session.getAttribute("customer");
       if(customerDTO!=null) {
           Long users_id = customerDTO.getIdUser();
           List<Order> orders = orderDAO.findAllByUser_Id(Customer.convertCustomerDTOToCustomer(customerDTO));
           return orders;
       }

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

    @Override
    public void OutOrders(HttpServletRequest request) {

        List<Order> orders=findAllOrdersCustomer(request);

        if (orders.size()==0)
            request.setAttribute("message2", "Orders is empty!");
        else {
            for(Order o: orders)
            {
                request.setAttribute("idOrder", o.getIdOrder().toString());
                request.setAttribute("status", o.getStatus().toString());
                request.setAttribute("amount", o.getAmount());
                request.setAttribute("dateCreate", o.getDateCreate());
                request.setAttribute("dateClose", o.getDateClose());
            }
            request.setAttribute("orders", orders);
        }
    }


}
