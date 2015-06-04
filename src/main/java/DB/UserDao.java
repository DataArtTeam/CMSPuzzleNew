package DB;


import context.User;

import java.util.ArrayList;

public interface UserDao {
    public ArrayList<User> getUsersByProperty(String name, String value);

    public void updateUser(User user);

}
