package com.accenture.flowershop.fe.servlets;


import com.accenture.flowershop.be.business.FlowerBusinessService;
import com.accenture.flowershop.be.business.OrderBusinessService;
import com.accenture.flowershop.be.business.RowOrderBusinessService;
import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.order.RowOrder;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.dto.CustomerDTO;
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

    @Autowired
    private RowOrderBusinessService rowOrderBusinessService;

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

        rowOrderBusinessService.OutRowOrders(request, orderBusinessService.OutOrders(request));

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

        buttonHandlerToTheBasket(request, response);
        buttonHandlerSaveOrder(request, response);
    }



    private void buttonHandlerSaveOrder(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException
    {
        if (request.getParameter("SaveOrder")!=null) {
            if(saveOrder(request))
                response.sendRedirect("/mainPage");
            else
            {
                request.setAttribute("Error", "Order not saved!");
                request.getRequestDispatcher("/mainPage.jsp").forward(request, response);
            }
        }
    }

    private boolean saveOrder(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        List<RowOrder> rowOrders=new ArrayList<RowOrder>();

        if (session.getAttribute("basket") != null)
            rowOrders = RowOrder.convertListRowOrderToListRowOrderDTO((List<RowOrderDTO>)session.getAttribute("basket"));

        if (rowOrderBusinessService.saveRowOrder(orderBusinessService.saveOrderCustomer(request), rowOrders)) {
            session.setAttribute("basket", null);
            return true;
        }
        else
            return false;
    }

    private  void buttonHandlerToTheBasket(HttpServletRequest request, HttpServletResponse response)
            throws  ServletException, IOException
    {
        List<Flower> flowers = flowerBusinessService.getFlowers();
        int countFlowers = flowerBusinessService.getLengthListFlowers();

        for (int i=0; i<countFlowers; i++) {

            Long id = flowers.get(i).getId();
            String buttonNumber = request.getParameter("Basket" + id);
            if (buttonNumber!= null)
            {
                BigDecimal count = new BigDecimal(0);
                if (request.getParameter("Count" + id)!=null)
                    count = new BigDecimal(request.getParameter("Count" + id));
                BigDecimal balance = flowerBusinessService.getFlowerById(id).getBalance();

                if (count.compareTo(BigDecimal.ZERO)==1
                        && ((count.compareTo(balance)==-1)
                        || (count.compareTo(balance)==0)))
                {

                    try {

                        AddRowOrderDTOInListAttribute(id, count, request);
                        flowerBusinessService.update(id, count); //обновить количество цветов
                        response.sendRedirect("/mainPage");
                        break;
                    } catch (Exception exc) {
                        request.setAttribute("Error", exc.toString());
                        request.getRequestDispatcher("/").forward(request, response);
                    }
                }
                else {
                    request.setAttribute("Error", "Incorrect number of flowers entered to add to the basket!");
                    request.getRequestDispatcher("/mainPage.jsp").forward(request, response);
                }
            }
        }
    }

    private void AddRowOrderDTOInListAttribute(Long id, BigDecimal count, HttpServletRequest request)
    {
        Flower flower = flowerBusinessService.getFlowerById(id);
        HttpSession session = request.getSession();
        List<RowOrderDTO> rowOrders;

        if (session.getAttribute("basket") == null)
            rowOrders = new ArrayList<RowOrderDTO>();
        else
            rowOrders = (List<RowOrderDTO>)session.getAttribute("basket");

        RowOrder rowOrder = new RowOrder(flower.getNameFlower(), count, flower.getPrice().multiply(count));

        if(rowOrders.size()==0) {
            rowOrders.add(RowOrderDTO.convertRowOrderToRowOrderDTO(rowOrder));
            session.setAttribute("basket", rowOrders);
        }
        else {
            Boolean flag=false;

            for (RowOrderDTO o : rowOrders) {
                if (o.getNameProduct().equals(rowOrder.getNameProduct())) {
                    flag=true;
                    BigDecimal countFlower = o.getCount();
                    o.setCount(rowOrder.getCount().add(countFlower));

                    BigDecimal priceFlower = o.getPrice();
                    o.setPrice(rowOrder.getPrice().add(priceFlower));
                    break;
                }
            }

            if (!flag)
                rowOrders.add(RowOrderDTO.convertRowOrderToRowOrderDTO(rowOrder));
        }
    }


}