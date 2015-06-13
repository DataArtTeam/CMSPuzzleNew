package servlets;

import context.UserSession;
import hibernate.dao.ContentDao;
import hibernate.dao.ContentPositionHistoryDao;
import hibernate.daoImpl.ContentDaoImpl;
import hibernate.daoImpl.ContentPositionHistoryDaoImpl;
import hibernate.tables.Content;
import context.ArticleStatus;
import hibernate.tables.ContentPositionHistory;
import hibernate.tables.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@WebServlet("/changeStatus")
public class StatusController extends ServletProvider {
    private static final String pageName = "/article_list";
    private static final String CONTENT_TYPE = "text/html";

    private static final String KEY_ID = "id";
    private static final String KEY_STATUS = "status";

    private String id;
    Content content;
    ArticleStatus articleStatus;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getRequestParam(request);
        content = getContent();
        content.setArticleStatus(articleStatus);
        commitChanges();
        addToHistory();
        response.setContentType(CONTENT_TYPE);
        super.forwardRequest(request, response, pageName);
    }

    private void getRequestParam(HttpServletRequest request){
        id = request.getParameter(KEY_ID);
        articleStatus = ArticleStatus.valueOf(request.getParameter(KEY_STATUS));
    }

    private Content getContent(){
        ContentDao contentDao = new ContentDaoImpl();
        try {
            Integer idInteger = new Integer(id);
            List<Content> contents = contentDao.getContentsByProperty("id", idInteger);
            if(contents.size() > 0){
                content = contents.get(0);
            }
        }
        catch (SQLException e){
            content = null;
        }
        return content;
    }

    private void commitChanges(){
        ContentDao contentDao = new ContentDaoImpl();
        try {
            contentDao.updateContent(content);
        }
        catch (SQLException e){

        }
    }

    private void addToHistory(){
        User user = UserSession.getUserSession().getUser();
        Timestamp date = new Timestamp(Calendar.getInstance().getTimeInMillis());

        ContentPositionHistory contentPositionHistory = new ContentPositionHistory(content, user, articleStatus, date);
        try {
            ContentPositionHistoryDao contentPosition = new ContentPositionHistoryDaoImpl();
            contentPosition.addContentPositionHistory(contentPositionHistory);
        }
        catch (SQLException e){

        }

    }


}

