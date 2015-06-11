package servlets;

import context.Article;
import hibernate.dao.ArticleDao;
import hibernate.daoImpl.ArticleDOAImpl;
import hibernate.tables.Content;
import context.ArticleStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/changeStatus")
public class StatusController extends ServletProvider {
    private static final String pageName = "/articlelist";
    private static final String CONTENT_TYPE = "text/html";

    private static final String KEY_ID = "id";
    private static final String KEY_STATUS = "status";

    private String id;
    Article article;
    ArticleStatus articleStatus;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getRequestParam(request);
        article = getArticle();
        article.setStatus(articleStatus);
        commitChanges();
        response.setContentType(CONTENT_TYPE);
        super.forwardRequest(request, response, pageName);
    }

    private void getRequestParam(HttpServletRequest request){
        id = request.getParameter(KEY_ID);
        articleStatus = ArticleStatus.valueOf(request.getParameter(KEY_STATUS));
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

    private void commitChanges(){
        ArticleDao articleDao = new ArticleDOAImpl();
        try {
            Content content = articleDao.convertToContent(article);
            articleDao.updateContent(content);
        }
        catch (SQLException e){

        }
    }
}

