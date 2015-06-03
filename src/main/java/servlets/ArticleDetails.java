package servlets;

import context.Article;
import context.ArticleList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/article")
public class ArticleDetails extends ServletProvider {

    private static final String pageName = "/ArticleDetails.jsp";
    private static final String CONTENT_TYPE = "text/html";
    private static final String KEY_ID = "id";

    private String id;
    Article article;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getRequestParam(request);
        ArticleList articleList = ArticleList.getArticleList();
        article = articleList.getArticleByID(id);
        setParametrs(request, article);
        response.setContentType(CONTENT_TYPE);
        super.forwardRequest(request, response, pageName);
    }

    private void getRequestParam(HttpServletRequest request){
        id = request.getParameter(KEY_ID);
    }

    private void setParametrs(HttpServletRequest request, Article article){
        request.getSession().setAttribute("name", article.getName());
        request.getSession().setAttribute("title", article.getTitle());
        request.getSession().setAttribute("keywords", article.getKeyWords());
        request.getSession().setAttribute("description", article.getDescription());
        request.getSession().setAttribute("text", article.getDescription());
    }
}
