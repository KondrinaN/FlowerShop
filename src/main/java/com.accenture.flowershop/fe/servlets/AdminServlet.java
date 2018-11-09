package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.OrderBusinessService;
import com.accenture.flowershop.be.business.RowOrderBusinessService;
import com.accenture.flowershop.be.business.UserBusinessService;
import com.accenture.flowershop.be.entity.flower.Flower;
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
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    @Autowired
    private UserBusinessService userBusinessService;

    @Autowired
    private OrderBusinessService orderBusinessService;

    @Autowired
    private RowOrderBusinessService rowOrderBusinessService;

    private static final long serialVersionUID = 1L;

    public void init(ServletConfig servletConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, servletConfig.getServletContext());
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html"); //отображение как html
        PrintWriter out = response.getWriter();

        rowOrderBusinessService.OutRowOrders(request, orderBusinessService.OutOrdersAllAdmin(request));

        request.getRequestDispatcher("/admin.jsp").forward(request, response);
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

    }
}
