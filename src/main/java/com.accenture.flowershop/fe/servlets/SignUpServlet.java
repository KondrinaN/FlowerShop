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
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/signUp")
public class SignUpServlet extends HttpServlet{

    @Autowired
    private UserBusinessService userService;

    private static final long serialVersionUID = 1L;

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, servletConfig.getServletContext());
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html"); //отображение как html
        PrintWriter out = response.getWriter();
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
        request.setAttribute("Login", param);
        request.setAttribute("CashBalance", request.getParameter("CashBalance"));
        request.setAttribute("Discount", request.getParameter("Discount"));

        CustomerDTO customerDTO = new CustomerDTO(request.getParameter("Login"), request.getParameter("Password"), request.getParameter("Surname"),
                request.getParameter("Name"), request.getParameter("Patronymic"), request.getParameter("Address"),
                2000, 0, UserShop.buyer);

        Customer customer = userService.register(customerDTO);


        if (!param.isEmpty() && !pwd.isEmpty())
            request.getRequestDispatcher("/mainPage.jsp").forward(request, response);
        else
        {
            request.setAttribute("Error", "Login can't be empty!");
            request.getRequestDispatcher("/").forward(request, response);
        }
    }
}