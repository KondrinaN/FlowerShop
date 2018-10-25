package com.accenture.flowershop.fe.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/mainPage")
public class MainPageServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

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
        String param = request.getParameter("Login");
        request.setAttribute("Login", param);
        request.getRequestDispatcher("/mainPage.jsp").forward(request, response);
        //super.doPost(request, response);
    }
}