package servlets;

import authorization.User;
import authorization.UsersList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends ServletProvider {

    private static final String CONTENT_TYPE = "text/html";
    private static final String PAGE_NAME = "/LoginPage.jsp";
    private static final String KEY_USERNAME = "user";
    private static final String KEY_PASSWORD = "password";
    private String userName;
    private String password;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getParametersFromRequest(request);
        boolean userIsInDB = userExists();
        if(!userIsInDB){

        }
        response.setContentType(CONTENT_TYPE);
        super.forwardRequest(request, response, PAGE_NAME);
    }

    private void getParametersFromRequest(HttpServletRequest request){
        userName = request.getParameter(KEY_USERNAME);
        password = request.getParameter(KEY_PASSWORD);
    }

    private boolean userExists(){
        User user = UsersList.findUser(userName);
        if(user == null) {
            return false;
        }
        return true;
    }
}
