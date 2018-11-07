package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.access.UserDAO;
import com.accenture.flowershop.be.business.FlowerBusinessService;
import com.accenture.flowershop.be.business.FlowerBusinessServiceImpl;
import com.accenture.flowershop.be.business.OrderBusinessService;
import com.accenture.flowershop.be.business.UserBusinessService;
import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.order.RowOrder;
import com.accenture.flowershop.fe.dto.FlowerDTO;
import com.accenture.flowershop.fe.dto.RowOrderDTO;
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

@WebServlet(urlPatterns = "/mainPage")
public class MainPageServlet extends HttpServlet{

    @Autowired
    private FlowerBusinessService flowerBusinessService;

    @Autowired
    private OrderBusinessService orderBusinessService;

    private static final long serialVersionUID = 1L;

    public void init(ServletConfig servletConfig) throws ServletException {
       SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, servletConfig.getServletContext());
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html"); //отображение как html
        PrintWriter out = response.getWriter();

        List<Flower> flowers = flowerBusinessService.findAllFlowers();

        flowerBusinessService.OutFoundFlower(flowers, request);

        flowerBusinessService.OutBasket(request);

        orderBusinessService.findAllOrdersCustomer(request);

       // request.setAttribute();
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

      int countFlowers = flowerBusinessService.getLengthListFlowers();


      for (int i=0; i<countFlowers; i++) {
            String buttonNumber = request.getParameter("Basket" +String.valueOf(i+1));
            if (buttonNumber!= null)
            {
                BigDecimal count = new BigDecimal(0);
                if (request.getParameter("Count" + String.valueOf(i+1))!=null)
                    count = new BigDecimal(request.getParameter("Count" + String.valueOf(i+1)));
                BigDecimal balance = flowerBusinessService.getFlowerById(i).getBalance();

                if (count.compareTo(BigDecimal.ZERO)==1
                        && ((count.compareTo(balance)==-1)
                        || (count.compareTo(balance)==0)))
                {
                    AddRowOrderDTOInListAttribute(i, count, request);
                    response.sendRedirect("/mainPage");
                }
                else {
                    request.setAttribute("Error", "Incorrect number of flowers entered to add to the basket!");
                    request.getRequestDispatcher("/mainPage.jsp").forward(request, response);
                }
                break;
            }
        }
    }

    private void AddRowOrderDTOInListAttribute(int id, BigDecimal count, HttpServletRequest request)
    {
        Flower flower = flowerBusinessService.getFlowerById(id);
        HttpSession session = request.getSession();
        List<RowOrderDTO> rowOrders;

        if (session.getAttribute("basket") == null)
            rowOrders = new ArrayList<RowOrderDTO>();
        else
            rowOrders = (List<RowOrderDTO>)session.getAttribute("basket");


        RowOrder rowOrder = new RowOrder(flower.getNameFlower(), count, flower.getPrice().multiply(count));
        rowOrders.add(RowOrderDTO.convertRowOrderToRowOrderDTO(rowOrder));
        session.setAttribute("basket", rowOrders);
    }
}