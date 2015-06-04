package controllers;

import access.Role;
import context.User;
import context.Article;
import context.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/website/archive")
public class ArticleArchiveController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    String getArticleArchive() {

        //TODO: find by id
        ArrayList<Tag> tags = new ArrayList<Tag>();
        Tag forestTag = new Tag(1, "forest");
        Tag worldTag = new Tag(2, "world");
        tags.add(forestTag);
        tags.add(worldTag);
        User user = new User("Victor", Role.AUTHOR, "Victor", "Pypkin");
        String text = "Recently, a lot of trees are cut down. Environmentalists are sounding the alarm. Our world is in danger.";

        Article article = new Article(6, "threat to forests" , "how many trees left in the world",
                "1432339200", "test", tags, user, text, "Our planet is in danger", "threat to forests", "testImg.png", 14,
                "forest, tree", 0);

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

