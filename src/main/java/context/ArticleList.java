package context;

import hibernate.dao.ArticleDao;
import hibernate.daoImpl.ArticleDOAImpl;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;

public class ArticleList {

    private static ArticleList articleList;

    Article article;
    Article article1;
    public ArrayList<Article> list;

    private ArticleList(){

        list = new ArrayList<Article>();
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

    public void updateArticleList(){

        ArticleDao articleDao = new ArticleDOAImpl();
        try {
            ArrayList<Article> articles = articleDao.getContentList();
            for (Article articlenew: articles){
              list.add(articlenew);
            }
        }
        catch (SQLException e){

        }



    }

}
