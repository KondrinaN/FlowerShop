package com.accenture.flowershop.fe.servlets;


import com.accenture.flowershop.be.business.FlowerBusinessService;
import com.accenture.flowershop.be.business.OrderBusinessService;
import com.accenture.flowershop.be.business.RowOrderBusinessService;
import com.accenture.flowershop.be.business.UserBusinessService;
import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.order.RowOrder;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.dto.CustomerDTO;
import com.accenture.flowershop.fe.dto.RowOrderDTO;
import com.accenture.flowershop.fe.enums.order.StatusOrder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet(urlPatterns = "/pay")
public class PayServlet extends HttpServlet{


    @Autowired
    private OrderBusinessService orderBusinessService;

    @Autowired
    private UserBusinessService userBusinessService;

    private static final long serialVersionUID = 1L;

    public void init(ServletConfig servletConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, servletConfig.getServletContext());
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html"); //отображение как html
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("/mainPage.jsp").forward(request, response);
    }

    /**
     * Принимает и отправляет POST посредством запроса
     * @param request запрос со стороны клиента
     * @param response ответ сервера
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws  ServletException, IOException{

       buttonHandlerToThePay(request, response);
    }

    private  void buttonHandlerToThePay(HttpServletRequest request, HttpServletResponse response)
            throws  ServletException, IOException
    {

        int countOrders = orderBusinessService.getLengthListOrders();

        HttpSession session = request.getSession();
        Customer customer = Customer.convertCustomerDTOToCustomer((CustomerDTO) session.getAttribute("customer"));

        if (customer != null) {
            BigDecimal cash=customer.getCashBalance(); //у пользователя

            for (int i=0; i<countOrders; i++) {
                String buttonNumber = request.getParameter("Order" + orderBusinessService.getIdByNumberPosition(i));
                if (buttonNumber!= null) {
                    BigDecimal amount = orderBusinessService.getCashBalance(i); //сумма заказа

                    if (cash.compareTo(BigDecimal.ZERO)==1 && (cash.compareTo(amount)==1 || cash.compareTo(amount)==0)) {
                        //оплатить, если хватает остатка
                        try {
                            orderBusinessService.updateStatusOrder(orderBusinessService.getOrderById(i), StatusOrder.paid);
                            BigDecimal newBalance = cash.subtract(amount);

                            session.setAttribute("customer", CustomerDTO.convertCustomerToCustomerDTO(userBusinessService.updateCashBalance(customer, newBalance)));

                            //поменять статус у заказа
                            response.sendRedirect("/mainPage");
                            break;
                        } catch (Exception exc) {
                            request.setAttribute("Error", exc.toString());
                            request.getRequestDispatcher("/").forward(request, response);
                        }
                    } else {
                        request.setAttribute("Error", "Cash balance is not enough to pay!");
                        request.getRequestDispatcher("/mainPage.jsp").forward(request, response);
                    }
                }
            }
        }
        else {
            request.setAttribute("Error", "Unable to pay!");
            request.getRequestDispatcher("/mainPage.jsp").forward(request, response);
        }
    }
}