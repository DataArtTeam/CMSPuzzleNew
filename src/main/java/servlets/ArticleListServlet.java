package servlets;

import context.Article;
import context.ArticleList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/articlelist")
public class ArticleListServlet extends ServletProvider{

    private static final String pageName = "/articleList.jsp";
    private static final String CONTENT_TYPE = "text/html";
    public ArrayList<Article> articleList;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        forwardRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        forwardRequest(request, response);
    }

    private void forwardRequest(HttpServletRequest request, HttpServletResponse response){
        response.setContentType(CONTENT_TYPE);
        fillArticleTable();
        request.getSession().setAttribute("articleList", articleList);
        try {
            super.forwardRequest(request, response, pageName);
        }
        catch (ServletException | IOException e){

        }
    }

    private void fillArticleTable(){
        context.ArticleList articles = context.ArticleList.getArticleList();
        articles.updateArticleList();
        articleList = articles.list;
    }
}
