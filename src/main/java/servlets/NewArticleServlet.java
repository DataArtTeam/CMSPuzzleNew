package servlets;

import access.Role;
import context.User;
import context.Article;
import context.ArticleList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/createArticle")
public class NewArticleServlet extends ServletProvider {
    private static final String pageName = "/main";
    private static final String CONTENT_TYPE = "text/html";

    private static final String KEY_TEXT = "text";
    private static final String KEY_NAME = "name";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_KEYWORDS = "kwds";

    private String text;
    private String name;
    private String title;
    private String description;
    private String keywords;
    private ArticleList articleList;



    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getParameters(request);
        articleList = ArticleList.getArticleList();
        int id = getLastId(articleList.list);
        Article article = new Article(id, name, description, "20150515", "url", null, new User("Nick", Role.AUTHOR, "Nick", "T"),
                text, title, "", "", 0, keywords, 0);
        articleList.list.add(article);
        response.setContentType(CONTENT_TYPE);
        super.forwardRequest(request, response, pageName);

    }

    private void getParameters(HttpServletRequest request){
        text = request.getParameter(KEY_TEXT);
        name = request.getParameter(KEY_NAME);
        title = request.getParameter(KEY_TITLE);
        description = request.getParameter(KEY_DESCRIPTION);
        keywords = request.getParameter(KEY_KEYWORDS);
    }

    private int getLastId(ArrayList<Article> articles){
        return 7;
    }
}
