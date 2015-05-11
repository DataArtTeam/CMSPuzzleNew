package authorization;


import access.UserRole;

public class User {

    String userName;
    UserRole role;

    public User(String userName, UserRole role){
        this.userName = userName;
        this.role = role;
    }

    public String getUserName(){
        return userName;
    }

    public UserRole getRole(){
       return role;
    }

    public String getPassword(){
        //TODO make normal
        return "123";
    }
}
