package servlets;

import hibernate.dao.ContentDao;
import hibernate.daoImpl.ContentDaoImpl;
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
    Content content;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getRequestParam(request);
        content = getContent();
        setParameters(request, content);
        response.setContentType(CONTENT_TYPE);
        super.forwardRequest(request, response, pageName);
    }

    private void getRequestParam(HttpServletRequest request){
        id = request.getParameter(KEY_ID);
    }

    private void setParameters(HttpServletRequest request, Content content){
        request.getSession().setAttribute("name", content.getName());
        request.getSession().setAttribute("title", content.getTitle());
        request.getSession().setAttribute("keywords", content.getKeywordsOfTags());
        request.getSession().setAttribute("description", content.getDescriptionOfContent());
        request.getSession().setAttribute("text", content.getText());
    }

    private Content getContent(){
        ContentDao articleDao = new ContentDaoImpl();
        try {
            Integer idInteger = new Integer(id);
            List<Content> contents = articleDao.getContentsByProperty("id", idInteger);
            if(contents.size() > 0){
                content = contents.get(0);
            }
        }
        catch (SQLException e){
            content = null;
        }
        return content;
    }

}
