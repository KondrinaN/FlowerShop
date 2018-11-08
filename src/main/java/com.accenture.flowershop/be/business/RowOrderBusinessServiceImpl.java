package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.RowOrderDAO;
import com.accenture.flowershop.be.access.RowOrderDAOImpl;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.order.RowOrder;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.dto.CustomerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service("rowOrderBusinessService")
public class RowOrderBusinessServiceImpl implements  RowOrderBusinessService{

    @Autowired
    private RowOrderDAO rowOrderDAO;

    private static final Logger LOG = 	LoggerFactory.getLogger(RowOrderBusinessServiceImpl.class);

    public RowOrderBusinessServiceImpl()
    {
        //LOG.debug("RowOrder");
        //System.out.println("rowOrderBusinessService");
    }

    @Override
    public void saveRowOrder(int idOrder) {

    }

    @Override
    public List<RowOrder> findAllRowOrder(Long idOrder, Order order) {
       return rowOrderDAO.findAll(idOrder, order);
    }

    @Override
    public void deleteRowOrder(int idOrder) {

    }

    public void OutRowOrders(HttpServletRequest request, List<Order> orders) {
        List<RowOrder> list = new ArrayList<RowOrder>();

        int count = orders.size();

        for (int i=0; i<count; i++) {
            List<RowOrder> rowOrders2 = findAllRowOrder(orders.get(i).getIdOrder(), orders.get(i));

            if (rowOrders2.size() == 0)
                request.setAttribute("message3", "Rows order is empty!");
            else {
                for (RowOrder o : rowOrders2) {
                    request.setAttribute("o.orderId.idOrder", o.getOrderId().getIdOrder());
                    request.setAttribute("nameProduct", o.getNameProduct());
                    request.setAttribute("count", o.getCount().toString());
                    request.setAttribute("price", o.getPrice().toString());
                    list.add(o);
                }
            }
        }

        request.setAttribute("countRowOrders", list.size());
        request.setAttribute("rowOrders2", list);
    }
}
