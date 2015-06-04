package controllers;

import context.ArticleList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/website/allarticles")
public class AllArticleController {

    @RequestMapping(value = "{pageNumber}", method = RequestMethod.GET)
    public @ResponseBody
    String getAllArticlesDetails(@PathVariable int pageNumber) {

        ArticleList articleList = ArticleList.getArticleList();
        String articleJSON = articleList.getArticlesInString();

        return articleJSON;
    }
}
