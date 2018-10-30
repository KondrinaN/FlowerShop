package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.UserBusinessService;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.dto.CustomerDTO;
import com.accenture.flowershop.fe.enums.customer.UserShop;
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

@WebServlet("/index")
public class LogInServlet extends HttpServlet {

    @Autowired
    private UserBusinessService userService;


    private static final long serialVersionUID = 1L;

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
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

        if(!param.isEmpty() && !pwd.isEmpty()) {
            request.setAttribute("Login", param);

            CustomerDTO customerDTO = new CustomerDTO(param, request.getParameter("Password"));

            Customer customer = null;

            try{
                customer = userService.logIn(param, pwd);

            }
            catch (Exception exc)
            {
                request.setAttribute("Error", "User not created!");
            }

            if (customer!=null)
            {

                if (pwd.equals(customer.getPassword())) {
                    HttpSession session = request.getSession();
                    session.setAttribute("customer", customerDTO.convertCustomerToCustomerDTO(customer));
                    response.sendRedirect("/mainPage");
                }
                else{
                    request.setAttribute("Error", "Wrong password!");
                    PrintWriter out = response.getWriter();
                    out.println("<HTML>");
                    out.println("<BODY>");
                    out.println("ERROR: " + request.getAttribute("Error"));
                    out.println("</BODY></HTML>");
                    request.getRequestDispatcher("/").forward(request, response);
                }

            }
            else {
                request.setAttribute("Error", "User not registered!");
                PrintWriter out = response.getWriter();
                out.println("<HTML>");
                out.println("<BODY>");
                out.println("ERROR: " + request.getAttribute("Error"));
                out.println("</BODY></HTML>");
                request.getRequestDispatcher("/").forward(request, response);
            }
        }
        else {
            request.setAttribute("Error", "Login or password can't be empty!");
            PrintWriter out = response.getWriter();
            out.println("<HTML>");
            out.println("<BODY>");
            out.println("ERROR: " + request.getAttribute("Error"));
            out.println("</BODY></HTML>");
            request.getRequestDispatcher("/").forward(request, response);
        }
    }
}
