package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/website/mainpage")
public class MainPageController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    String getAllArticlesFromMainPage() {
//
//        ArticleList articleList = ArticleList.getArticleList();
//        String articleJSON = articleList.getArticlesInString();
//
//        return articleJSON;
    return "";
   }
}
