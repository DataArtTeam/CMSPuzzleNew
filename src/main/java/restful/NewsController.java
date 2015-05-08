package restful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    private final String title="Java и web";
    private final String kwds="Java web";
    private final String desc="kf";
    private final String img="/img.img";
    private final String text="Some text";
    private final String author="Pinguin";

    @RequestMapping("/news")
    public News news(@RequestParam(value="id", defaultValue="404") String id){
        return new News(id,title,kwds,desc,img,text,author);
    }
}
