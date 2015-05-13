package DB;

import java.util.ArrayList;

import access.AccessLevel;
import access.UserRole;
import context.Article;

public abstract class DAO {

   public abstract ArrayList<Article> getArticles(AccessLevel accessLevel);

    public abstract UserRole getRole();


}
