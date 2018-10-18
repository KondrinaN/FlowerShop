package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/catalog")
public class FlowerShopCatalogServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
       /* response.setContentType("text/html"); //отображение как html
        PrintWriter out = response.getWriter();
        out.println("Heeeeello!"); //отправка ответа с сервера клиенту
        */
       response.getWriter().print("I am servlet!");
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

        String param = (String)request.getSession().getAttribute("parameter");
        super.doPost(request, response);
    }
}