package controllers;

import access.providers.FrontPageProvider;
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
        FrontPageProvider frontPageProvider = new FrontPageProvider();
        String contents = frontPageProvider.getContentInJson();
        return contents;
    }
}
