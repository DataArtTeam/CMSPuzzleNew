package context;

import authorization.User;

public class Article {

    int id;
    public User author;
    String name;
    public String title;
    String kwds;
    String description;
    String text;
    ArticleStatus status;

    public Article (User author, String title, String description){
        this.author = author;
        this.title = title;
        this.description = description;
        this.id =1;
        this.name = "New Article";
        this.text = "ba bla bla";
        this.status = ArticleStatus.ASSERT_EDITOR;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }
}
