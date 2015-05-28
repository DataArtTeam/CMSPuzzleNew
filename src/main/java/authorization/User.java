package authorization;


import access.Role;
import context.ContextObject;
import org.json.JSONException;
import org.json.JSONObject;

public class User implements ContextObject {

    private String userName;
    private Role role;
    private String firstName;
    private String lastName;

    private static final String KEY_NAME = "name";
    private static final String KEY_FIRST_NAME = "firstname";
    private static final String KEY_LAST_NAME = "lastname";

    public User(String userName){
        this.userName = userName;
        getUserFromBD();
    }

    public User(String userName, Role role, String firstName, String lastName){
        this.userName = userName;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName(){
        return userName;
    }

    public Role getRole(){
       return role;
    }

    public String getPassword(){
        //TODO make normal
        return "123";
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

    private void getUserFromBD(){

    }
}
