package controllers;

import context.ListTags;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/website/alltags")
public class TagsController {

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public @ResponseBody
    String getAllTags() {
        ListTags listTags = new ListTags();
        return listTags.getTagsInString();
    }
}
