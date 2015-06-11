package servlets;

import context.Article;
import hibernate.dao.ArticleDao;
import hibernate.daoImpl.ArticleDOAImpl;
import hibernate.tables.Content;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


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
        article = getArticle();
        setParameters(request, article);
        response.setContentType(CONTENT_TYPE);
        super.forwardRequest(request, response, pageName);
    }

    private void getRequestParam(HttpServletRequest request){
        id = request.getParameter(KEY_ID);
    }

    private void setParameters(HttpServletRequest request, Article article){
        request.getSession().setAttribute("name", article.getName());
        request.getSession().setAttribute("title", article.getTitle());
        request.getSession().setAttribute("keywords", article.getKeyWords());
        request.getSession().setAttribute("description", article.getDescription());
        request.getSession().setAttribute("text", article.getDescription());
    }

    private Article getArticle(){
        ArticleDao articleDao = new ArticleDOAImpl();
        try {
            Integer idInteger = new Integer(id);
            List<Content> contents = articleDao.getContentsByProperty("id", idInteger);
            if(contents.size() > 0){
                Content content = contents.get(0);
                article = articleDao.convertToArticle(content);
            }
        }
        catch (SQLException e){
            article = null;
        }
        return article;
    }

}
