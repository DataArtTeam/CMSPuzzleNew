package context;

import hibernate.dao.UserDao;
import hibernate.daoImpl.UserDaoImpl;
import hibernate.tables.User;
import hibernate.tables.userInfo.UserRole;
import org.json.JSONException;
import org.json.JSONObject;

import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;
import java.util.List;

public class UserSession implements ContextObject {

    private static UserSession userSessionInst;
    String userName;
    UserRole role;
    String firstName;
    String lastName;
    Integer userID;

    private static final String KEY_NAME = "name";
    private static final String KEY_FIRST_NAME = "firstname";
    private static final String KEY_LAST_NAME = "lastname";

    private UserSession(){

    }

    public static synchronized UserSession getUserSession(){
        if (userSessionInst == null){
            userSessionInst = new UserSession();
        }
        return userSessionInst;
    }

    public void fillUserAttribute(String userName, String firstName, String lastName, UserRole role, Integer userID){
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.userID = userID;
    }

    public String getName(){
        return userName;
    }

    public UserRole getRole(){
       return role;
    }

    public JSONObject createFullJSON() {
        try {
            JSONObject userJSON = new JSONObject();
            userJSON.put(KEY_NAME, userName);
            userJSON.put(KEY_FIRST_NAME, firstName);
            userJSON.put(KEY_LAST_NAME, lastName);
            return userJSON;
        }
        catch (JSONException e){
            return null;

        }
    }

    public String getStringJSON() {
       String userInJSON = createFullJSON().toString();
        return userInJSON;
    }

    public void setRole(UserRole role){
        this.role = role;
    }

    public Integer getUserID(){
        return userID;
    }

    public User getUser(){

        User user = null;
        UserDao userDao = new UserDaoImpl();
        try {
            List<User> users = userDao.getUsers();
            if(users != null){
                if (users.size() > 0){
                 user = users.get(0);
                }
            }
        }
        catch (SQLException e){

        }

        return user;
    }
}
