package access;


import authorization.User;

public class AccessProvider {

    public AccessLevel getUserAccess(User user){
        Role userRole = user.getRole();
        AccessLevel accessLevel;
        switch (userRole){
            case USER:
                accessLevel = AccessLevel.NONE;
                break;
            case ADMINISTRATOR:
            case EDITOR:
                accessLevel = AccessLevel.FULL_ACCESS;
                break;
            case CORRECTOR:
                accessLevel = AccessLevel.OWN_CORRECTORS;
                break;
            default:
                accessLevel = AccessLevel.NONE;
        }
        return accessLevel;
    }
}
