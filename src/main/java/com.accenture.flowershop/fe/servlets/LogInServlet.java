package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.FlowerBusinessService;
import com.accenture.flowershop.be.business.UserBusinessService;
import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.dto.CustomerDTO;
import com.accenture.flowershop.fe.dto.FlowerDTO;
import com.accenture.flowershop.fe.enums.customer.UserShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.persistence.NoResultException;
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
import java.util.List;

@WebServlet("/index")
public class LogInServlet extends HttpServlet {

    @Autowired
   // private FlowerBusinessService flowerBusinessService;
    private UserBusinessService userService;


    private static final long serialVersionUID = 1L;

    public void init(ServletConfig servletConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, servletConfig.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); //отображение как html
        request.getRequestDispatcher("/").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("Login");
        String pwd = request.getParameter("Password");

        if(!param.isEmpty() && !pwd.isEmpty())
        {
            request.setAttribute("Login", param);

            try{
                Customer customer = userService.logIn(param, pwd);
                HttpSession session = request.getSession();
                session.setAttribute("customer", CustomerDTO.convertCustomerToCustomerDTO(customer));
                response.sendRedirect("/mainPage");
            }
            catch (Exception exc)
            {
                request.setAttribute("Error", exc.toString());
                request.getRequestDispatcher("/").forward(request, response);
            }
        }
        else {
            request.setAttribute("Error", "Login or password can't be empty!");
            request.getRequestDispatcher("/").forward(request, response);
        }
    }
}
