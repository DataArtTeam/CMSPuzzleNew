package controllers;

import context.Article;
import context.ArticleList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/website/article")
public class ArticleController {

    @RequestMapping(value = "{url}", method = RequestMethod.GET)
    public @ResponseBody
    String getArticleDetails(@PathVariable String url) {

//        //TODO: find by id
//        ArrayList<Tag> tags = new ArrayList<Tag>();
//        Tag forestTag = new Tag(1, "forest");
//        Tag worldTag = new Tag(2, "world");
//        tags.add(forestTag);
//        tags.add(worldTag);
//        User user = new User("Victor", Role.AUTHOR, "Victor", "Pypkin");
//        String text = "Recently, a lot of trees are cut down. Environmentalists are sounding the alarm. Our world is in danger.";
//
//        Article article = new Article(id, "threat to forests" , "how many trees left in the world",
//                "1432339200", "test", tags, user, text, "Our planet is in danger", "threat to forests", "testImg.png", 14,
//                "forest, tree", 0);

        ArticleList articleList = ArticleList.getArticleList();
        Article article = articleList.getArticleByURL("forest");

        String articleJSON = article.getStringJSON();
        if(articleJSON != null){
            return articleJSON;
        }
        else {
            //TODO: what return
            return "";
        }

    }

}