package servlets;

import controllers.TagListSingleton;
import hibernate.dao.TagDao;
import hibernate.daoImpl.TagDaoImpl;
import hibernate.tables.Tag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/selectTags")
public class CheckTagsControllers extends ServletProvider{

    private static final String pageName = "/NewArticle.jsp";
    private static final String CONTENT_TYPE = "text/html";
    private static final String KEY_CHECKBOX = "selected";
    String[] tags;
    TagListSingleton tagList;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        tags = request.getParameterValues(KEY_CHECKBOX);
        getTagByID();
        response.setContentType(CONTENT_TYPE);
        super.forwardRequest(request, response, pageName);
    }

    private void getTagByID(){
        ArrayList<Tag> tagsList = new ArrayList<>();
        tagList = TagListSingleton.getTagList();
        TagDao tagDao = new TagDaoImpl();
        for (String id: tags){
            Integer intId = new Integer(id);
            try {
                Tag tag = tagDao.getTag(intId);
                tagsList.add(tag);
            }
            catch (SQLException e){

            }
        }
        tagList.setTagsList(tagsList);
    }
}
