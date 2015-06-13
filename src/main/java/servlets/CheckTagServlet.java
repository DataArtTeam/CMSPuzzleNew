package servlets;


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
import java.util.List;

@WebServlet("/checktag")
public class CheckTagServlet extends ServletProvider{

    private static final String pageName = "/checkTag.jsp";
    private static final String CONTENT_TYPE = "text/html";
    private static final String KEY_TAG_LIST = "tagList";

    ArrayList<Tag> tags;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getAllTags();
        setParameters(request);
        response.setContentType(CONTENT_TYPE);
        super.forwardRequest(request, response, pageName);
    }

    private void getAllTags(){
        tags = new ArrayList<Tag>();
        TagDao tagDao = new TagDaoImpl();
        try {
            List<Tag> tagList = tagDao.getTags();
            for (Tag tag:tagList){
                tags.add(tag);
            }
        }
        catch (SQLException e){

        }
    }

    private void setParameters(HttpServletRequest request){
        request.getSession().setAttribute(KEY_TAG_LIST, tags);
    }
}
