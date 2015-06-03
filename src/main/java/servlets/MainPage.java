package servlets;


import DB.DAO;
import access.AccessLevel;
import access.AccessProvider;
import access.Role;
import authorization.User;
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
    public ArrayList<Article> articleList;
    private User currentUser;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        fillArticleTable();
        request.getSession().setAttribute("articleList", articleList);
        super.forwardRequest(request, response, pageName);
    }

    private void fillArticleTable(){
        //TODO - убрать потом
        currentUser = new User("Anna", Role.AUTHOR, "Anna", "Petrova");
        AccessProvider accessProvider = new AccessProvider();
        DAO dao = new DAO();

        AccessLevel accessLevel = accessProvider.getUserAccess(currentUser);
        articleList = ArticleList.getArticleList().list;
    }
}
