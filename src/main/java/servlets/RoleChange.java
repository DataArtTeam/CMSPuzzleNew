package servlets;

import access.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


@WebServlet("/role")
public class RoleChange extends HttpServlet {

    Role role;
    String page = "Added.jsp";
    ArrayList<String> roleList = new ArrayList<String>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        roleList.add("USER");
        roleList.add("ADMINISTRATOR");
        roleList.add("AUTHOR");
        roleList.add("CORRECTOR");
        roleList.add("EDITOR");
        req.setAttribute("role", roleList/*Arrays.toString(Role.values())*/);

        req.getRequestDispatcher(page).forward(req, resp);

    }
}