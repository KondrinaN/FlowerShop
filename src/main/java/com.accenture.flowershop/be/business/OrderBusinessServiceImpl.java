package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.OrderDAO;
import com.accenture.flowershop.be.access.OrderDAOImpl;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.order.RowOrder;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.dto.CustomerDTO;
import com.accenture.flowershop.fe.dto.RowOrderDTO;
import com.accenture.flowershop.fe.enums.order.StatusOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("orderBusinessService")
public class OrderBusinessServiceImpl implements OrderBusinessService {

    @Autowired
    private OrderDAO orderDAO;

    private List<Order> orders;


    @Override
    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public int getLengthListOrders() {
        return orders.size();
    }

    @Override
    public BigDecimal getCashBalance(int numberPosition) {
        return orders.get(numberPosition).getAmount();
    }

    @Override
    public Long getIdByNumberPosition(int numberPosition)
    {
        if (numberPosition<orders.size())
            return orders.get(numberPosition).getIdOrder();
        else
            return new Long(0);
    }

    private static final Logger LOG = 	LoggerFactory.getLogger(OrderBusinessServiceImpl.class);



    public OrderBusinessServiceImpl()
    {
        orders = new ArrayList<Order>();
        //LOG.debug("Order");
       // System.out.println("orderBusinessService");
    }

    @Override
    public Order getOrderById(int id) {
        return orders.get(id);
    }



    @Override
    @Transactional
    public Order saveOrderCustomer(HttpServletRequest request) {
        HttpSession session = request.getSession();
        CustomerDTO customerDTO = (CustomerDTO)session.getAttribute("customer");
        if (customerDTO!=null) {
            BigDecimal amount = (BigDecimal)session.getAttribute("priceFull");
            return orderDAO.save(Customer.convertCustomerDTOToCustomer(customerDTO), amount);
        }
        return null;
    }

    @Override
    @Transactional
    public void updateStatusOrder(Order order) throws Exception {
        orderDAO.update(order);
    }

    @Override
    public List<Order> findAllOrdersCustomer(HttpServletRequest request) {
       HttpSession session = request.getSession();
       CustomerDTO customerDTO = (CustomerDTO)session.getAttribute("customer");
       if(customerDTO!=null) {
           Long users_id = customerDTO.getIdUser();
           orders = orderDAO.findAllByUser_Id(Customer.convertCustomerDTOToCustomer(customerDTO));
           return orders;
       }

        return null;
    }

    @Override
    public List<Order> findAllOrdersAdmin(HttpServletRequest request) {

            orders = orderDAO.findAll();
            return orders;
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
    public void delete(int idOrder) {

    }

    @Override
    public List<Order> OutOrders(HttpServletRequest request) {

        List<Order> orders=findAllOrdersCustomer(request);

        if (orders!=null) {
            if (orders.size() == 0)
                request.setAttribute("message2", "Orders is empty!");
            else {
                for (Order o : orders) {
                    request.setAttribute("idOrder", o.getIdOrder().toString());

                    request.setAttribute("status", o.getStatus().toString());
                    request.setAttribute("amount", o.getAmount());
                    request.setAttribute("dateCreate", o.getDateCreate());
                    request.setAttribute("dateClose", o.getDateClose());
                }

                request.setAttribute("countOrders", orders.size());
                request.setAttribute("orders", orders);
            }
        }
        return orders;
    }

    public List<Order> OutOrdersAllAdmin(HttpServletRequest request) {

        List<Order> orders=findAllOrdersAdmin(request);

        if (orders!=null) {
            if (orders.size() == 0)
                request.setAttribute("message2", "Orders is empty!");
            else {
                for (Order o : orders) {
                    request.setAttribute("idOrder", o.getIdOrder().toString());

                    request.setAttribute("status", o.getStatus().toString());
                    request.setAttribute("amount", o.getAmount());
                    request.setAttribute("dateCreate", o.getDateCreate());
                    request.setAttribute("dateClose", o.getDateClose());
                }

                request.setAttribute("countOrders", orders.size());
                request.setAttribute("orders", orders);
            }
        }
        return orders;
    }
}
