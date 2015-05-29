package authorization;


import access.Role;

public class User {

    String userName;
    Role role;
    String firstName;
    String lastName;

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

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getUsername(){
        return userName;
    }

    public void setStatus(UserStatus userStatus){

    }
}
