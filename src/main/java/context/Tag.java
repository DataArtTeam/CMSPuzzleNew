package context;

import org.json.JSONException;
import org.json.JSONObject;

public class Tag implements ContextObject{

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    private int id;
    private String name;

    public Tag(int id, String name){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public String getStringJSON() {

        String tagInString = getTagInJSON().toString();
        return tagInString;

    }

    public JSONObject getTagInJSON(){
        try {
            JSONObject tagJSON = new JSONObject();
            tagJSON.put(KEY_ID, id);
            tagJSON.put(KEY_NAME, name);
            return tagJSON;
        }
        catch (JSONException e){
            return null;
        }
    }
}
