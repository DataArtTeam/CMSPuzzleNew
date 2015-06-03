package controllers;

import access.Role;
import authorization.User;
import context.Article;
import context.ArticleList;
import context.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/website/allarticles")
public class AllArticleController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    String getAllArticlesDetails() {

        ArticleList articleList = ArticleList.getArticleList();
        String articleJSON = articleList.getArticlesInString();

        return articleJSON;
    }
}
