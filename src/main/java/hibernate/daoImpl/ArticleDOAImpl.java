package hibernate.daoImpl;

import context.Article;
import context.Tag;
import context.UserSession;
import hibernate.dao.ArticleDao;
import hibernate.tables.Content;
import hibernate.util.HibernateDaoBuilder;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ArticleDOAImpl implements ArticleDao {

    @Override
    public void addContent(Article article) throws SQLException {

        Byte status = 1;
        Timestamp timeStamp = Timestamp.valueOf("2015-06-06 23:59:59");
        Content content = new Content(article.getId(), article.getName(),article.getTitle(), article.getKeyWords(), article.getDescription(),
                article.getImg(), article.getDescription(), article.getText(), status, timeStamp, timeStamp, article.getUrl(), article.getStatus());
        HibernateDaoBuilder.saveTableValue(content);
    }

    public ArrayList<Article> getContentList() throws SQLException {
        ArrayList<Article> articles = new ArrayList<>();
      List<Content> contents = HibernateDaoBuilder.getContentsList(new Content());
        for (Content content: contents){
            Article article = convertToArticle(content);
            articles.add(article);
        }
        return articles;
    }

    public Article convertToArticle(Content content){
        ArrayList<Tag> tags = new ArrayList<>();
        UserSession userSession = UserSession.getUser();
        Article article = new Article(content.getId(), content.getName(), content.getDescriptionOfContent(),
                "20152306", "forest", tags, userSession, content.getText(),
                content.getTitle(), content.getDescriptionOfContent(), content.getImage(), 5,
                content.getKeywordsOfTags(), content.getArticleStatus());
        return article;
    }

    public Content convertToContent(Article article){
        ArrayList<Tag> tags = new ArrayList<>();
        UserSession userSession = UserSession.getUser();
        Timestamp timestamp = Timestamp.valueOf("2015-06-06 23:59:59");
        Byte status = 1;
        Content content = new Content(article.getId(), article.getName(), article.getTitle(),
                article.getKeyWords(),article.getKeyWords(),article.getImg(),
                article.getDescription(), article.getText(), status,
                timestamp, timestamp, article.getUrl(),  article.getStatus());
        return content;
    }

    public List<Content> getContentsByProperty(String propertyName,
                                               Object propertyValue) throws SQLException {
        return (List<Content>)HibernateDaoBuilder.getTableValuesByProperty(propertyName, propertyValue, new Content());
    }

    public void updateContent(Content content) throws SQLException {
        HibernateDaoBuilder.updateTableValue(content);
    }
}
