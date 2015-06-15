package servlets.content;


import context.ContentEditMode;
import context.ContentSession;
import hibernate.daoImpl.ContentDaoImpl;
import hibernate.tables.Content;
import servlets.ServletProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/content_details")
public class ContentDetailsServlet extends ServletProvider {

    private static final String pageName = "content_view.jsp";
    private static final String CONTENT_TYPE = "text/html";
    private static final String KEY_CONTENT_ID = "id";
    String id;
    Content content;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getParametersFromRequest(request);
        getContent();
        response.setContentType(CONTENT_TYPE);
        super.forwardRequest(request, response, pageName);
    }

    private void getParametersFromRequest(HttpServletRequest request){
        id = request.getParameter(KEY_CONTENT_ID);
    }

    private void getContent(){
        ContentDaoImpl contentDao = new ContentDaoImpl();
        Integer intID = new Integer(id);
        try{
            content = contentDao.getContent(intID);
            createContentSession();
        }
        catch (SQLException e){

        }
    }

    private void createContentSession(){

        ContentSession contentSession = ContentSession.getContentSession();
        contentSession.createContentSession(content.getId(), content.getName(), content.getTitle(), content.getText(),
                content.getDescriptionOfContent(), content.getKeywordsOfTags(), content.getImage(),  content.getUrl(),
                ContentEditMode.EDIT_MODE);
    }
}
