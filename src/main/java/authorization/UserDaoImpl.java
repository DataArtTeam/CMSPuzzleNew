package authorization;


import DB.UserDao;
import access.Role;

import java.util.ArrayList;

public class UserDaoImpl implements UserDao {

    public ArrayList<User> getUsersByProperty(String name, String value){

        User user = new User ("user1", Role.AUTHOR);
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(user);
        return userList;

    }

    public void updateUser(User user){

    }
}
