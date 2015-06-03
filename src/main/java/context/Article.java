package context;

import authorization.User;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Article implements ContextObject{

    private static final String KEY_NAME            = "name";
    private static final String KEY_ID              = "id";
    private static final String KEY_DESCRIPTION     = "description";
    private static final String KEY_CREATED         = "created";
    private static final String KEY_URL             = "url";
    private static final String KEY_TAGS            = "tags";
    private static final String KEY_AUTHOR          = "author";
    private static final String KEY_TEXT            = "text";
    private static final String KEY_TITLE           = "title";
    private static final String KEY_DESCR           = "descr";
    private static final String KEY_REVIEW          = "review";
    private static final String KEY_IMG             = "img";
    private static final String KEY_KWDS            = "kwds";
    private static final String KEY_SIMILAR         = "similar";

    private int id;
    private String name;
    private String imagePath;
    private String description;
    private String created;
    private String url;
    private int review;
    private ArrayList<Tag> tags;
    public User author;
    private String text;
    private String title;
    private String kwds;
    private String descr;
    private int mode;

    public Article (int id, String name, String description, String created, String url,  ArrayList<Tag> tags,
                    User author, String text, String title, String descr, String imagePath, int review, String kwds, int mode){

        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
        this.url = url;
        this.tags = tags;
        this.author = author;
        this.text = text;
        this.title = title;
        this.descr = descr;
        this.imagePath = imagePath;
        this.review = review;
        this.kwds = kwds;
        this.descr = descr;
        this.mode = mode;

    }


    public Article(int id){
        this.id = id;
        getArticleFromDB();
    }

    public Article (int id, String name, String imagePath, String created, String url){
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.created = created;
        this.url = url;
    }

    public JSONObject createFullJSON() {

        try {
            JSONObject articleData = new JSONObject();
            articleData.put(KEY_ID,            id);
            articleData.put(KEY_NAME,          name);
            articleData.put(KEY_DESCRIPTION,   description);
            articleData.put(KEY_CREATED,       created);
            articleData.put(KEY_URL,           url);
            articleData.put(KEY_IMG,           imagePath);
            articleData.put(KEY_REVIEW,        review);
            articleData.put(KEY_TAGS,          getTagsName());
            articleData.put(KEY_AUTHOR,        author.getName());
            articleData.put(KEY_TEXT,          text);
            articleData.put(KEY_TITLE,         title);
            articleData.put(KEY_TITLE,         title);
            articleData.put(KEY_KWDS,          kwds);
            articleData.put(KEY_DESCR,         descr);
            articleData.put(KEY_SIMILAR,       getSimilarArticles());


            return articleData;
        }
        catch (JSONException e){
            return null;
        }

    }
    public JSONObject createAbbreviatedJSON(){
        try {

            JSONObject articleData = new JSONObject();
            articleData.put(KEY_ID,            id);
            articleData.put(KEY_NAME,          name);
            articleData.put(KEY_DESCRIPTION,   description);
            articleData.put(KEY_CREATED,       created);
            articleData.put(KEY_URL,           url);
            articleData.put(KEY_IMG,           imagePath);
            articleData.put(KEY_REVIEW,        review);
            articleData.put(KEY_TAGS,          getTagsName());
            articleData.put(KEY_AUTHOR,        author.createFullJSON());

            return articleData;
        }
        catch (JSONException e){
            return null;
        }
    }

    public JSONObject createJSONObjectForSimilar(){

        try {

            JSONObject articleData = new JSONObject();
            articleData.put(KEY_ID,            id);
            articleData.put(KEY_NAME,          name);
            articleData.put(KEY_CREATED,       created);
            articleData.put(KEY_IMG,           imagePath);
            articleData.put(KEY_URL,           url);

            return articleData;
        }
        catch (JSONException e){
            return null;
        }

    }

    public String getStringJSON() {
        JSONObject articleInJSON;

        if(mode == 0){
            articleInJSON = createFullJSON();
        }
        else {
            articleInJSON = createAbbreviatedJSON();
        }

        String articleInString = articleInJSON.toString();

        return articleInString;
    }


    private ArrayList<JSONObject> getTagsName(){

        ArrayList<JSONObject> tagsName = new ArrayList<JSONObject>();

        for (Tag tag: tags){
            tagsName.add(tag.getTagInJSON());
        }

        return tagsName;
    }

    private void getArticleFromDB(){
        //TODO: builder for BD
    }

    private ArrayList<JSONObject> getSimilarArticles(){
        ArticleList articleList = ArticleList.getArticleList();
        return articleList.getSimilarArticles(id);
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public String getName(){
        return name;
    }

    public String getKeyWords(){
        return kwds;
    }

    public String getText(){
        return text;
    }

    public int getId(){
        return id;
    }

    public String getUrl(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("/article?id=");
        stringBuffer.append(id);
        return stringBuffer.toString();
    }
}
