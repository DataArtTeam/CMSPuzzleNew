package context;


public class ContentSession {

    private static ContentSession contentSession;

    public String text;
    public String name;
    public String title;
    public String description;
    public String keywords;
    public String link;
    public String image;
    public Integer id;
    public ContentEditMode editMode;

    private ContentSession(){

    }

    public static synchronized ContentSession getContentSession(){
        if(contentSession == null) {
            contentSession = new ContentSession();
        }

        return contentSession;
    }

    public void createContentSession(int id, String name, String title,  String text, String description,
                                     String keywords, String link, String image, ContentEditMode contentEditMode){
        this.id = id;
        this.name = name;
        this.title = title;
        this.text = text;
        this.description = description;
        this.keywords = keywords;
        this.link = link;
        this.image = image;
        this.editMode = contentEditMode;
    }

    public void updateSession(String name, String title,  String text, String description,
                              String keywords, String link, String image){
        createContentSession(id, name, title, text, description, keywords, link, image, ContentEditMode.EDIT_MODE);

    }

    public void removeInstance(){
        contentSession = null;
    }
}
