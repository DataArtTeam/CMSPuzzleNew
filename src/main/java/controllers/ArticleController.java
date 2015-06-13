package controllers;

import hibernate.dao.ContentDao;
import hibernate.daoImpl.ContentDaoImpl;
import hibernate.tables.Content;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/website/article")
public class ArticleController {

    Content content;

    @RequestMapping(value = "{url}", method = RequestMethod.GET)
    public @ResponseBody
    String getArticleDetails(@PathVariable String url) {

        ArrayList<Content> contents = new ArrayList<>();
        getContent(url);
        String contentJSON = content.getStringJSON(0);
        if(contentJSON != null){
            return contentJSON;
        }
        else {
            //TODO: return 404
            return "";
        }

    }

    private void getContent(String url){
        ContentDao contentDao = new ContentDaoImpl();
        try {
            List<Content> contentList = contentDao.getContentsByProperty("url", url);
            if(contentList != null){
                if(contentList.size()>0){
                    content = contentList.get(0);
                }
            }
        }
        catch (SQLException e){

        }
    }

}