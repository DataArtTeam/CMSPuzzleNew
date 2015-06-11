package servlets;


import context.Article;
import hibernate.dao.ArticleDao;
import hibernate.dao.UserDao;
import hibernate.daoImpl.ArticleDOAImpl;
import hibernate.daoImpl.UserDaoImpl;
import hibernate.tables.Content;
import hibernate.tables.User;
import hibernate.tables.userInfo.UserRole;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/editstatus")
public class ArticleStatusServlet extends ServletProvider{

    private static final String pageName = "/articleStatusEdit.jsp";
    private static final String CONTENT_TYPE = "text/html";
    private static final String KEY_ARTICLE_ID = "id";
    private static final String KEY_ARTICLE = "article";
    private static final String KEY_USERS = "users";

    String articleID;
    Article article;
    ArrayList<User> users;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        getParametersFromRequest(request);
        article = getArticle();
        users = getUsers();
        setResponseParameters(request);
        try {
            super.forwardRequest(request, response, pageName);
        }
        catch (ServletException | IOException e){

        }
    }

    private void getParametersFromRequest(HttpServletRequest request){
        articleID = request.getParameter(KEY_ARTICLE_ID);
    }

    private Article getArticle(){
        ArticleDao articleDao = new ArticleDOAImpl();
        try {
            Integer id = new Integer(articleID);
            List<Content> contents = articleDao.getContentsByProperty("id", id);
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

    private void setResponseParameters(HttpServletRequest request){
        request.getSession().setAttribute(KEY_ARTICLE, article);
        request.getSession().setAttribute(KEY_USERS, users);
    }

    private ArrayList<User> getUsers(){
        users = new ArrayList<>();
        UserDao userDao = new UserDaoImpl();
        try {
            List<User> userList = userDao.getUsers();
            for(User user: userList){
                UserRole userRole = user.getRole();
                if(userRole == UserRole.CORRECTOR)
                    users.add(user);
            }
        }
        catch (SQLException e){

        }
        return users;
    }
}
