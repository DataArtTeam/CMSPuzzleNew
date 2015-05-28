package servlets;


import access.AccessLevel;
import context.Article;
import context.ArticleList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/main")
public class MainPage extends ServletProvider{

    private static final String pageName = "/Tabs.jsp";
    private static final String CONTENT_TYPE = "text/html";
    private AccessLevel accessLevel;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        super.forwardRequest(request, response, pageName);
    }

    private void fillArticleTable(){
        //TODO access level
    }
}
