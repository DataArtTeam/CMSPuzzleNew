package context;


import hibernate.dao.ContentDao;
import hibernate.daoImpl.ContentDaoImpl;
import hibernate.tables.Content;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContentList {

    ArrayList<Content> contents;
    public int sizeList;

    public ContentList() {
        getAllContent();
        this.sizeList = contents.size();
    }

//    public String getContentInString(){
//        list = getAllContent();
//        StringBuffer articleString = new StringBuffer();
//        articleString.append("[");
//        int listSize = list.size();
//        int amount = 1;
//        for(Article articles: list){
//            articleString.append(articles.getStringJSON());
//            if(amount < listSize){
//                articleString.append(",");
//            }
//            amount++;
//        }
//        articleString.append("]");
//        return articleString.toString();
//    }

    private void getAllContent() {
        contents = new ArrayList<>();
        try {
            ContentDao contentDao = new ContentDaoImpl();
            List<Content> contentList = contentDao.getContents();
            for (Content content : contentList) {
                contents.add(content);
            }
        } catch (SQLException e) {

        }
    }

    public ArrayList<Content> getContents(int amountOnPage, int pageNumber) {
        ArrayList<Content> contentPagination = new ArrayList<>();
        int lastNumber = amountOnPage*pageNumber;
        int firstNumber = lastNumber - amountOnPage + 1;
        int currentNumber = firstNumber;
        if(contents.size() < lastNumber){
            lastNumber = contents.size();
        }
        while (currentNumber <= lastNumber){
            Content content = contents.get(currentNumber-1);
            contentPagination.add(content);
            currentNumber++;
        }
        return contentPagination;

    }

}
