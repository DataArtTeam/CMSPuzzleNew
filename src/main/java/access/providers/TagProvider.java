package access.providers;

import hibernate.dao.ContentTagLinkerDao;
import hibernate.dao.TagDao;
import hibernate.daoImpl.ContentTagLinkerDaoImpl;
import hibernate.daoImpl.TagDaoImpl;
import hibernate.tables.Content;
import hibernate.tables.ContentTagLinker;
import hibernate.tables.Tag;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TagProvider {

    private static final String KEY_CONTENT_ID = "content";

    public String getTagsJSON(){
        return "";
    }

    private Tag getTagByID(Integer id){
        Tag tag = null;
        TagDao tagDao = new TagDaoImpl();
        try {
            tag = tagDao.getTag(id);
        }
        catch (SQLException e){

        }
        return tag;
    }

    public String getContentTagInJSON(Content content){

        ArrayList<Tag> tags = getTagsFromList(content);
        String tagsInString = createTagsArrayInString(tags);

        return tagsInString;
    }

    private String createTagsArrayInString(ArrayList<Tag> tags){

        StringBuffer tagsArray = new StringBuffer();
        tagsArray.append("[");

        int arraySize = tags.size();
        int currentAmount = 1;


        for (Tag tag: tags){
            JSONObject tagJSON = tag.getTagInJSON();
            tagsArray.append(tagJSON);
            if(currentAmount < arraySize){
                tagsArray.append(",");
                currentAmount++;
            }
        }

        tagsArray.append("]");

        return tagsArray.toString();

    }

    private ArrayList<Tag> getTagsFromList(Content content){
        ArrayList<Tag> tags = new ArrayList<>();
        List<ContentTagLinker> contentTagLinkers = getRelatedLinkers(content);

        for (ContentTagLinker contentTagLinker: contentTagLinkers){
            Tag tag = contentTagLinker.getTag();
            tags.add(tag);
        }

        return tags;

    }

    private List<ContentTagLinker> getRelatedLinkers(Content content){

        List<ContentTagLinker> contentTagLinkers = null;

        ContentTagLinkerDao contentTagLinkerDao = new ContentTagLinkerDaoImpl();
        try {
            contentTagLinkers =
                    contentTagLinkerDao.getContentTagLinkersByProperty(KEY_CONTENT_ID, content);
        }
        catch (SQLException e){

        }
        return contentTagLinkers;
    }


}
