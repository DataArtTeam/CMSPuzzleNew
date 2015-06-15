package servlets.content;

import context.ContentEditMode;
import context.ContentSession;
import hibernate.tables.Tag;
import servlets.ServletProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/add_content")
public class AddingContentServlet extends ServletProvider {

    private static final String pageName = "/select_tag";
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
    ContentSession contentSession;
    ArrayList<Tag> tags;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getParameters(request);
        contentSession = ContentSession.getContentSession();
        if(contentSession.editMode == ContentEditMode.EDIT_MODE) {
            updateContent();
            //getTags();
        }
        else {
            createContent();
        }


        response.setContentType(CONTENT_TYPE);
        super.forwardRequest(request, response, pageName);

    }

    private void createContent(){
        contentSession.createContentSession(0, name, title, text, description, keywords, link, imageName, ContentEditMode.CREATE_MODE);
    }

    private void updateContent(){
        contentSession.updateSession(name, title, text, description, keywords, link, imageName);
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
}
