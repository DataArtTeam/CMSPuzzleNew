package DB;

import java.util.ArrayList;

import access.AccessLevel;
import access.Role;
import context.Article;

public abstract class DAO {

   public abstract ArrayList<Article> getArticles(AccessLevel accessLevel);

    public abstract Role getRole();


}
