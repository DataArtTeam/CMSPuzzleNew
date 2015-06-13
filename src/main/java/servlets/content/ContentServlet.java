package servlets.content;

import context.*;
import controllers.TagListSingleton;
import hibernate.dao.ContentDao;
import hibernate.dao.ContentPositionHistoryDao;
import hibernate.dao.UserDao;
import hibernate.daoImpl.ContentDaoImpl;
import hibernate.daoImpl.ContentPositionHistoryDaoImpl;
import hibernate.daoImpl.UserDaoImpl;
import hibernate.tables.Content;
import hibernate.tables.ContentPositionHistory;
import hibernate.tables.Tag;
import hibernate.tables.User;
import servlets.ServletProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@WebServlet("/createArticle")
public class ContentServlet extends ServletProvider {
    private static final String pageName = "/article_list";
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
    private ArrayList<Content> contentList;



    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getParameters(request);
        User user = getUser();
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        ArrayList<Tag> tags = TagListSingleton.getTagList().getTags();
        Content content = new Content(name, title, tags, imageName, description,
                text, timestamp, link, ArticleStatus.AUTHOR, user);

        ContentDao contentDao = new ContentDaoImpl();
        try {
            contentDao.addContent(content);
            addToHistory(content, user);
        }
        catch (SQLException e){

        }

        response.setContentType(CONTENT_TYPE);
        super.forwardRequest(request, response, pageName);

    }

    private User getUser(){
        UserDao userDao = new UserDaoImpl();
        User user =null;
        try {
            List<User> users = userDao.getUsersByProperty("login", UserSession.getUserSession().getName());
            if (users != null){
                user = users.get(0);
            }
        }
        catch (SQLException e){

        }
        return user;
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

    private void addToHistory(Content content, User user){
        Timestamp date = new Timestamp(Calendar.getInstance().getTimeInMillis());
        ContentPositionHistory contentPositionHistory = new ContentPositionHistory(content, user, ArticleStatus.AUTHOR, date);

        try {
            ContentPositionHistoryDao contentPosition = new ContentPositionHistoryDaoImpl();
            contentPosition.addContentPositionHistory(contentPositionHistory);
        }
        catch (SQLException e){

        }
   }
}
