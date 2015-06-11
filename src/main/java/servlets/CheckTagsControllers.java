package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectTags")
public class CheckTagsControllers extends ServletProvider{

    private static final String pageName = "/NewArticle.jsp";
    private static final String CONTENT_TYPE = "text/html";
    private static final String KEY_CHECKBOX = "selected";
    String[] tags;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        tags = request.getParameterValues(KEY_CHECKBOX);
        response.setContentType(CONTENT_TYPE);
        super.forwardRequest(request, response, pageName);
    }
}
