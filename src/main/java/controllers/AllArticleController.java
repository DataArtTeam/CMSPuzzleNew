package controllers;

import access.providers.ContentListProvider;
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
        ContentListProvider contentListProvider = new ContentListProvider();
        String contentsInString = contentListProvider.getContentsByNumber(pageNumber);
        return contentsInString;
    }
}
