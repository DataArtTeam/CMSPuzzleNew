package DB;

import java.util.ArrayList;

import access.AccessLevel;
import access.Role;
import authorization.User;
import context.Article;

public class DAO {

   public ArrayList<Article> getArticles(AccessLevel accessLevel){
       ArrayList<Article> articleList = new ArrayList<Article>();
       User user = new User("usr1", Role.ADMINISTRATOR);
       Article article = new Article(user, "Some title", "Some desc");
       Article article1 = new Article(user, "Some title fv", "Some desc fv");
       articleList.add(article);
       articleList.add(article1);

       return articleList;
   }


}
