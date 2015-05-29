package DB;


import access.Role;
import authorization.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {
    public ArrayList<User> getUsersByProperty(String name, String value);

    public void updateUser(User user);

}
