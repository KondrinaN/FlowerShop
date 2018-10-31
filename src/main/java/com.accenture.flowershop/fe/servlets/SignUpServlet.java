package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.UserBusinessService;
import com.accenture.flowershop.be.business.UserBusinessServiceImpl;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.dto.CustomerDTO;
import com.accenture.flowershop.fe.enums.customer.UserShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.RequestDispatcher;
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

@WebServlet(urlPatterns = "/signUp")
public class SignUpServlet extends HttpServlet{

    @Autowired
    private UserBusinessService userService;

    private static final long serialVersionUID = 1L;

    public void init(ServletConfig servletConfig) throws ServletException {
       SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, servletConfig.getServletContext());
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html"); //отображение как html
        request.getRequestDispatcher("/signUp.jsp").forward(request, response);
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

        String param = request.getParameter("Login");
        String pwd = request.getParameter("Password");

        if(!param.isEmpty() && !pwd.isEmpty()) {
            request.setAttribute("Login", param);

            CustomerDTO customerDTO = new CustomerDTO(param, request.getParameter("Password"), request.getParameter("Surname"),
                    request.getParameter("Name"), request.getParameter("Patronymic"), request.getParameter("Address"),
                    new BigDecimal(2000),  new BigDecimal(0), UserShop.buyer);

            Customer customer = null;

            try {
                customer = userService.register(param, request.getParameter("Password"), request.getParameter("Surname"),
                        request.getParameter("Name"), request.getParameter("Patronymic"), request.getParameter("Address"),
                        new BigDecimal(2000), new BigDecimal(0), UserShop.buyer);
            } catch (Exception exc) {
                request.setAttribute("Error", "User not created!");
            }

            if (customer != null) {
                HttpSession session = request.getSession();
                session.setAttribute("customer", customerDTO.convertCustomerToCustomerDTO(customer));

                response.sendRedirect("/mainPage");
                //request.getRequestDispatcher("/mainPage.jsp").forward(request, response);
            }
        }
        else {
            request.setAttribute("Error", "First fill in the fields!");
            PrintWriter out = response.getWriter();
            out.println("<HTML>");
            out.println("<BODY>");
            out.println("ERROR: " + request.getAttribute("Error"));
            out.println("</BODY></HTML>");
            request.getRequestDispatcher("/signUp.jsp").forward(request, response);
        }
    }
}