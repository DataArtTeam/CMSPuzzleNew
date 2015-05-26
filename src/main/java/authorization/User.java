package authorization;


import access.Role;

public class User {

    String userName;
    Role role;

    public User(String userName, Role role){
        this.userName = userName;
        this.role = role;
    }

    public String getUserName(){
        return userName;
    }

    public Role getRole(){
       return role;
    }

    public String getPassword(){
        //TODO make normal
        return "123";
    }

    public String getUsername(){
        return userName;
    }

}
