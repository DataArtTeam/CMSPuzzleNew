package servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(description = "to register a new user", urlPatterns = { "/registration" })
public class Registration extends ServletProvider{

    private static final String pageName = "/registration.jsp";
    private static final String CONTENT_TYPE = "text/html";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType(CONTENT_TYPE);
        super.forwardRequest(request, response, pageName);
    }
}
