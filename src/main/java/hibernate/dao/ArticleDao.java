package hibernate.dao;


import context.Article;
import hibernate.tables.Content;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ArticleDao {

    public void addContent(Article article) throws SQLException;

    public ArrayList<Article> getContentList() throws SQLException;

    public List<Content> getContentsByProperty(String propertyName,
                                               Object propertyValue) throws SQLException;

    public Article convertToArticle(Content content);

    public void updateContent(Content content) throws SQLException;

    public Content convertToContent(Article article);
}
