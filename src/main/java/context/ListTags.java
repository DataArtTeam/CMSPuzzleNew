package context;


import hibernate.dao.TagDao;
import hibernate.daoImpl.TagDaoImpl;
import hibernate.tables.Tag;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListTags {

    private static final String KEY_TAGS = "tags";

    public String getTagsInString(){

        ArrayList<Tag> tags = getAllTags();
        ArrayList<JSONObject> tagsInJSON = new ArrayList<JSONObject>();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        int listSize = tags.size();
        int amount = 1;
        for (Tag tag: tags){
            //tagsInJSON.add(tag.getTagInJSON());
            stringBuffer.append(tag.getTagInJSON());
            if (amount < listSize){
                stringBuffer.append(",");
            }
            amount ++;

        }
        stringBuffer.append("]");
        return stringBuffer.toString();

//        try {
//            JSONObject listTagsJSON = new JSONObject();
//            listTagsJSON.put(KEY_TAGS, tagsInJSON);
//            return listTagsJSON.toString();
//        }
//        catch (JSONException e){
//            return null;
//        }

    }

    public ArrayList<Tag> getAllTags(){
        ArrayList<Tag> tags = new ArrayList<>();
        TagDao tagDao = new TagDaoImpl();
        try {
            List<Tag> tagList =tagDao.getTags();
            for (Tag tag: tagList){
                tags.add(tag);
            }
        }
        catch (SQLException e){

        }
        return tags;
    }
}
