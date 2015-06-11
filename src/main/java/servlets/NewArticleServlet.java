package servlets;

import context.UserSession;
import context.Article;
import context.ArticleList;
import hibernate.dao.ArticleDao;
import hibernate.dao.ContentPositionHistoryDao;
import hibernate.daoImpl.ArticleDOAImpl;
import hibernate.daoImpl.ContentPositionHistoryDaoImpl;
import hibernate.tables.Content;
import hibernate.tables.ContentPositionHistory;
import context.ArticleStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/createArticle")
public class NewArticleServlet extends ServletProvider {
    private static final String pageName = "/articlelist";
    private static final String CONTENT_TYPE = "text/html";

    private static final String KEY_TEXT = "text";
    private static final String KEY_NAME = "name";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_KEYWORDS = "kwds";
    private static final String KEY_LINK = "link";
    private static final String KEY_IMAGE_NAME = "imageName";

    private String text;
    private String name;
    private String title;
    private String description;
    private String keywords;
    private String link;
    private String imageName;
    private ArticleList articleList;



    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getParameters(request);
        articleList = ArticleList.getArticleList();
        int id = getLastId(articleList.list);
        Article article = new Article(id, name, description, "20150515", link, null, UserSession.getUser(),
                text, title, "", imageName, 0, keywords, ArticleStatus.AUTHOR);
        articleList.list.add(article);
        ArticleDao articleDao = new ArticleDOAImpl();
        try {
            Content content = articleDao.convertToContent(article);
            articleDao.addContent(article);
            addToHistory(content);
        }
        catch (SQLException e){

        }

        response.setContentType(CONTENT_TYPE);
        super.forwardRequest(request, response, pageName);

    }

    private void getParameters(HttpServletRequest request){
        text = request.getParameter(KEY_TEXT);
        name = request.getParameter(KEY_NAME);
        title = request.getParameter(KEY_TITLE);
        description = request.getParameter(KEY_DESCRIPTION);
        keywords = request.getParameter(KEY_KEYWORDS);
        link = request.getParameter(KEY_LINK);
        imageName = request.getParameter(KEY_IMAGE_NAME);
    }

    private int getLastId(ArrayList<Article> articles){
        return 7;
    }

    private void addToHistory(Content content){
//        Integer userID = UserSession.getUser().getUserID();
//        Timestamp date = Timestamp.valueOf("2015-10-06 23:59:59");
//        ContentPositionHistory contentPositionHistory = new ContentPositionHistory();
//        contentPositionHistory.setContentId(content.getId());
//        contentPositionHistory.setUserId(userID);
//        contentPositionHistory.setDate(date);
//
//        try {
//            ContentPositionHistoryDao contentPosition = new ContentPositionHistoryDaoImpl();
//            contentPosition.addContentPositionHistory(contentPositionHistory);
//        }
//        catch (SQLException e){
//
//        }
   }
}
