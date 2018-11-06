package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.FlowerBusinessService;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    @Autowired
    private FlowerBusinessService flowerBusinessService;

    private static final long serialVersionUID = 1L;

    public void init(ServletConfig servletConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, servletConfig.getServletContext());
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html"); //отображение как html
        PrintWriter out = response.getWriter();
        Boolean flag = false;

        List<Flower> flowers = new ArrayList<Flower>();

        String action = request.getParameter("Search");

        if("Search by range price".equals(action)) {
            String min = request.getParameter("minPrice");
            String max = request.getParameter("maxPrice");
            if ((min.isEmpty() && max.isEmpty()) || (min.isEmpty() && !max.isEmpty()) || (!min.isEmpty() && max.isEmpty()))
                request.setAttribute("Error", "Not all fields (minPrice and MaxPrice) for search are filled!");
            else {
                BigDecimal minB= new BigDecimal(min);
                BigDecimal maxB = new BigDecimal(max);
                if(minB.compareTo(BigDecimal.ZERO)==1 && maxB.compareTo(BigDecimal.ZERO)==1 && maxB.compareTo(minB)==1) {
                    flowers = flowerBusinessService.findFlowerByRangePrice(new BigDecimal(request.getParameter("minPrice")), new BigDecimal(request.getParameter("maxPrice")));
                    flag = true;
                }
                else
                    request.setAttribute("Error", "Invalid price format. The maximum price must be greater than the minimum. And both should not be less than or equal to 0!");
            }
        }
        else if ("Search by name".equals(action)) {
            if(!request.getParameter("NameFlower").isEmpty()) {
                flowers = flowerBusinessService.findFlowerByName(request.getParameter("NameFlower"));
                flag = true;
            }
            else
                request.setAttribute("Error", "The name of the flower for search should not be empty!");
        }

        if (flag)
           flowerBusinessService.OutFoundFlower(flowers, request);

        request.getRequestDispatcher("/search.jsp").forward(request, response);
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


       /* String param = request.getParameter("Login");

        if (!param.isEmpty()) {
            request.getRequestDispatcher("/mainPage.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("Error", "Login can't be empty!");
            request.getRequestDispatcher("/").forward(request, response);
        }*/
    }


}
