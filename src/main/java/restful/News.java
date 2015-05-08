package restful;

public class News {

    private final String id;
    private final String title;
    private final String kwds;
    private final String desc;
    private final String img;
    private final String text;
    private final String author;

    public News(String id, String title, String kwds, String desc, String img, String text, String author) {
        this.id = id;
        this.title = title;
        this.kwds = kwds;
        this.desc = desc;
        this.img = img;
        this.text = text;
        this.author = author;
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public String getKwds() {
        return kwds;
    }

    public String getDesc() {
        return desc;
    }

    public String getImg() {
        return img;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }
}
