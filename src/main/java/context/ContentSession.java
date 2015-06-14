package context;


public class ContentSession {

    private static ContentSession contentSession;

    public String text;
    public   String name;
    public String title;
    public String description;
    public String keywords;
    public String link;
    public String image;

    private ContentSession(){

    }

    public static synchronized ContentSession getContentSession(){
        if(contentSession == null) {
            contentSession = new ContentSession();
        }

        return contentSession;
    }

    public void createContentSession(String name, String title,  String text, String description,
                                     String keywords, String link, String image){
        this.name = name;
        this.title = title;
        this.text = text;
        this.description = description;
        this.keywords = keywords;
        this.link = link;
        this.image = image;
    }
}
