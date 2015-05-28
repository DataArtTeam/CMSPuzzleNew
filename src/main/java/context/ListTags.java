package context;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListTags {

    private static final String KEY_TAGS = "tags";

    public String getTagsInString(){

        ArrayList<Tag> tags = getAllTags();
        ArrayList<JSONObject> tagsInJSON = new ArrayList<JSONObject>();

        for (Tag tag: tags){
            tagsInJSON.add(tag.getTagInJSON());
        }

        try {
            JSONObject listTagsJSON = new JSONObject();
            listTagsJSON.put(KEY_TAGS, tagsInJSON);
            return listTagsJSON.toString();
        }
        catch (JSONException e){
            return null;
        }
    }

    public ArrayList<Tag> getAllTags(){

        ArrayList<Tag> tags = new ArrayList<Tag>();

        Tag forestTag = new Tag(1, "forest");
        Tag worldTag = new Tag(2, "world");
        Tag delicacyTag = new Tag(6, "delicacy");
        Tag provenceTag = new Tag(3, "Provence");
        Tag franceTag   = new Tag(4, "France");

        tags.add(forestTag);
        tags.add(worldTag);
        tags.add(delicacyTag);
        tags.add(provenceTag);
        tags.add(franceTag);

        return tags;

    }
}
