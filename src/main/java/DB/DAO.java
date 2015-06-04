package DB;

import java.util.ArrayList;

import access.AccessLevel;
import access.Role;
import authorization.User;
import context.Article;
import context.Tag;

public class DAO {

   public ArrayList<Article> getArticles(AccessLevel accessLevel){
       ArrayList<Article> articleList = new ArrayList<Article>();
       //TODO: find by id
       ArrayList<Tag> tags1 = new ArrayList<Tag>();
       Tag forestTag = new Tag(1, "forest");
       Tag worldTag = new Tag(2, "world");
       tags1.add(forestTag);
       tags1.add(worldTag);
       User user = new User("Victor", Role.AUTHOR, "Victor", "Pypkin");
       String text = "Recently, a lot of trees are cut down. Environmentalists are sounding the alarm. Our world is in danger.";

       Article article = new Article(1, "threat to forests" , "how many trees left in the world",
               "1432339200", "forest", tags1, user, text, "Our planet is in danger", "threat to forests", "testImg.png", 14,
               "forest, tree", 1);

       //TODO: find by id
       ArrayList<Tag> tags2 = new ArrayList<Tag>();
       Tag foodTag = new Tag(5,"food");
       Tag delicacyTag = new Tag(6, "delicacy");
       Tag provenceTag = new Tag(3, "Provence");
       Tag franceTag   = new Tag(4, "France");
       tags2.add(foodTag);
       tags2.add(delicacyTag);
       tags2.add(provenceTag);
       tags2.add(franceTag);
       User user1 = new User("Mike", Role.AUTHOR, "Mike", "Smith");
       String text1 = "In the south of Provence, you can try delicacies. For example, cheeses and wines. " +
               "They are considered the best in the world. " +
               "The mass pilgrimage begins in the summer and ditsya until mid autumn.";

       Article article1 = new Article(2, "new side of Provence" , "that every man should see, coming to France",
               "1432339200", "Provence", tags2, user1, text1, "the magic of Provence", "the magic of Provence", "Provence.png", 14,
               "France, Provence", 1);
       articleList.add(article);
       articleList.add(article1);

       return articleList;
   }


}
