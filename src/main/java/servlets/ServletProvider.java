package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class ServletProvider extends HttpServlet {

    @Override
    public abstract void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    public void forwardRequest(HttpServletRequest request, HttpServletResponse response, String pageName)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(pageName);

        dispatcher.forward(request, response);
    }
}