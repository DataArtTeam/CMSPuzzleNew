package context;

import access.Role;
import org.json.JSONObject;

import java.util.ArrayList;

public class ArticleList {

    private static ArticleList articleList;

    Article article;
    Article article1;
    public ArrayList<Article> list;

    private ArticleList(){

        list = new ArrayList<Article>();

        //TODO: find by id
        ArrayList<Tag> tags1 = new ArrayList<Tag>();
        Tag forestTag = new Tag(1, "forest");
        Tag worldTag = new Tag(2, "world");
        tags1.add(forestTag);
        tags1.add(worldTag);
        User user = new User("Victor", Role.AUTHOR, "Victor", "Pypkin");
        String text = "Recently, a lot of trees are cut down. Environmentalists are sounding the alarm. Our world is in danger.";

        article = new Article(1, "threat to forests" , "how many trees left in the world",
                "1432339200", "test", tags1, user, text, "Our planet is in danger", "threat to forests", "http://178.212.192.72:8080/imagine", 14,
                "forest, tree", 1);

        //TODO: find by id
        ArrayList<Tag> tags2 = new ArrayList<Tag>();
        Tag foodTag = new Tag(5,"food");
        Tag delicacyTag = new Tag(6, "delicacy");
        Tag provenceTag = new Tag(3, "Provence");
        Tag franceTag   = new Tag(4, "France");
        tags2.add(foodTag);
        tags2.add(delicacyTag);
        tags2.add(provenceTag);
        tags2.add(franceTag);
        User user1 = new User("Mike", Role.AUTHOR, "Mike", "Smith");
        String text1 = "In the south of Provence, you can try delicacies. For example, cheeses and wines. " +
                "They are considered the best in the world. " +
                "The mass pilgrimage begins in the summer and ditsya until mid autumn.";

        article1 = new Article(2, "new side of Provence" , "that every man should see, coming to France",
                "1432339200", "test", tags2, user1, text1, "the magic of Provence", "the magic of Provence", "Provence.png", 14,
                "France, Provence", 1);

        list.add(article);
        list.add(article1);

    }
    public static ArticleList getArticleList(){
        if (articleList == null){
            return new ArticleList();
        }
        return articleList;
    }

    public String getArticlesInString(){


        StringBuffer articleString = new StringBuffer();
        articleString.append("[");
        int listSize = list.size();
        int amount = 1;
        for(Article articles: list){
            articleString.append(articles.getStringJSON());
            if(amount < listSize){
                articleString.append(",");
            }
            amount++;
        }
        articleString.append("]");
        return articleString.toString();
    }

    public ArrayList<JSONObject> getSimilarArticles(int id){

        ArrayList<Article> articles = getArticlesByTags();
        ArrayList<JSONObject> articlesInSON = new ArrayList<JSONObject>();

        for (Article article: articles){
            JSONObject articleJSON = article.createJSONObjectForSimilar();
            articlesInSON.add(articleJSON);
        }

        return articlesInSON;
    }

    private ArrayList<Article> getArticlesByTags(){

        ArrayList<Article> articles = new ArrayList<Article>();

        Article article1 = new Article(3, "What air we breathe", "http://178.212.192.72:8080/imagine", "1432339200", "url1");
        Article article2 = new Article(5, "Red Book for the year is greater than", "http://178.212.192.72:8080/imagine", "1432339200", "url1");
        Article article3 = new Article(8, "How can we help nature", "http://178.212.192.72:8080/imagine", "1432339200", "url1");

        articles.add(article1);
        articles.add(article2);
        articles.add(article3);

        return articles;
    }

    public Article getArticleByID(String id){
        Integer idInt = new Integer(id);
        if (idInt == 1){
            return article;
        }
        else if (idInt == 2){
            return article1;
        }
        else {
            return null;
        }
    }

    public Article getArticleByURL(String url){
        if (url == "forest"){
            return article;
        }
        else {
            return article1;
        }
    }

}
