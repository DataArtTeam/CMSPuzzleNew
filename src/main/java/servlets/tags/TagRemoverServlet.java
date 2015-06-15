package servlets.tags;

import controllers.TagListSingleton;
import hibernate.dao.TagDao;
import hibernate.daoImpl.TagDaoImpl;
import hibernate.tables.Tag;
import servlets.ServletProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/remove_tag")
public class TagRemoverServlet extends ServletProvider{

    private static final String pageName = "/tags";
    private static final String CONTENT_TYPE = "text/html";
    private static final String KEY_CHECKBOX = "selected";
    String[] tags;
    ArrayList<Tag> tagList;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getParametersFromRequest(request);
        getTagByID();
        removeTags();
        response.setContentType(CONTENT_TYPE);
        super.forwardRequest(request, response, pageName);
    }

    private void getParametersFromRequest(HttpServletRequest request){
        tags = request.getParameterValues(KEY_CHECKBOX);
        getTagByID();
    }

    private void getTagByID(){
        tagList = new ArrayList<>();
        TagDao tagDao = new TagDaoImpl();
        for (String id: tags){
            Integer intId = new Integer(id);
            try {
                Tag tag = tagDao.getTag(intId);
                tagList.add(tag);
            }
            catch (SQLException e){

            }
        }
    }

    private void removeTags(){
        TagDao tagDao = new TagDaoImpl();
        try {
            for (Tag tag: tagList){
                tagDao.deleteTag(tag);
            }

        }
        catch (SQLException e){

        }
    }

}
