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

        List<Flower> flowers = new ArrayList<Flower>();

        String action = request.getParameter("Search");

        if("Search by range price".equals(action))
            flowers = flowerBusinessService.findFlowerByRangePrice(new Double(request.getParameter("minPrice")), new Double(request.getParameter("maxPrice")));
        else if ("Search by name".equals(action))
            flowers = flowerBusinessService.findFlowerByName(request.getParameter("NameFlower"));

        if(flowers.size()!=0) {
            for (Flower f:flowers)
            {
                request.setAttribute("nameFlower", f.getNameFlower());
                request.setAttribute("balance", f.getBalance());
                request.setAttribute("price", f.getPrice());
                request.setAttribute("flowerAvailability", f.getFlowerAvailability());
            }

            request.setAttribute("flowers", flowers);
        }
        else
            request.setAttribute("Error", "Flowers not found!");

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
