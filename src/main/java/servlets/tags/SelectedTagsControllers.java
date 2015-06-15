package servlets.tags;

import context.ArticleStatus;
import context.ContentEditMode;
import context.ContentSession;
import context.UserSession;
import controllers.TagListSingleton;
import hibernate.dao.ContentDao;
import hibernate.dao.ContentPositionHistoryDao;
import hibernate.dao.ContentTagLinkerDao;
import hibernate.dao.TagDao;
import hibernate.daoImpl.ContentDaoImpl;
import hibernate.daoImpl.ContentPositionHistoryDaoImpl;
import hibernate.daoImpl.ContentTagLinkerDaoImpl;
import hibernate.daoImpl.TagDaoImpl;
import hibernate.tables.*;
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

@WebServlet("/selectTags")
public class SelectedTagsControllers extends ServletProvider {

    private static final String pageName = "/article_list";
    private static final String CONTENT_TYPE = "text/html";
    private static final String KEY_CHECKBOX = "selected";
    String[] tags;
    TagListSingleton tagList;
    Content content;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getParametersFromRequest(request);
        getTagByID();
        createArticle();
        createTagsOfContent();
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

    private void getParametersFromRequest(HttpServletRequest request){
        tags = request.getParameterValues(KEY_CHECKBOX);
    }

    private void createArticle(){
        ContentSession contentSession = ContentSession.getContentSession();
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        User user = UserSession.getUserSession().getUser();


        ContentDao contentDao = new ContentDaoImpl();
        try {
            if(contentSession.editMode == ContentEditMode.CREATE_MODE){
                content = new Content(contentSession.name, contentSession.title, contentSession.image,
                        contentSession.description, contentSession.text, timestamp, contentSession.link, ArticleStatus.AUTHOR, user);
                contentDao.addContent(content);
                addToHistory();
            }
            else {
                content = new Content(contentSession.id, contentSession.name, contentSession.title, contentSession.image,
                        contentSession.description, contentSession.text, timestamp, contentSession.link, ArticleStatus.AUTHOR, user);
                contentDao.updateContent(content);
            }

        }
        catch (SQLException e){

        }
        finally {
            ContentSession.getContentSession().removeInstance();
        }

    }

    private void createTagsOfContent(){
        TagListSingleton tagListSingleton = TagListSingleton.getTagList();
        ArrayList<Tag> tags = tagListSingleton.getTags();
        ContentTagLinkerDao contentTagLinkerDao = new ContentTagLinkerDaoImpl();
        try {
            for (Tag tag: tags){
                ContentTagLinker contentTagLinker = new ContentTagLinker(content, tag);
                contentTagLinkerDao.addLink(contentTagLinker);
            }
        }
        catch (SQLException e){

        }

    }

    private void addToHistory(){
        User user = UserSession.getUserSession().getUser();
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
