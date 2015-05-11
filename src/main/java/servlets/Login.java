package servlets;

import hibernate.dao.UserDao;
import hibernate.general.HibernateFactory;
import hibernate.tables.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import diferent.UserStatus;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HibernateFactory factory = HibernateFactory.getInstance();
	UserDao userDaoImpl = factory.getUserDao();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		request.setAttribute("login", login);
		request.setAttribute("password", password);
		System.out.println("Login servlet working...");
		try{
			if ((login == "") || (login == null) || (password == "")|| (password == null)) {
//				request.setAttribute("access_wrong", true);
				getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
				return;
			}
			List<User> users = null;
			try {
				users = userDaoImpl.getUsers();
				if ((users != null) && (!users.isEmpty())) {
					for (User user : users) {
						if (user.getLogin().equals(login)) {
							request.setAttribute("firstname", user.getFirstName());
							request.setAttribute("lastname", user.getLastName());
							if (user.getPassword().equals(password)) {
								request.setAttribute("access_wrong", false);
								/*
								 * TODO add change user info into DAO
								 */
//								user.setStatus(UserStatus.available);
//								userDaoImpl.
								getServletContext().getRequestDispatcher("/successLogin.jsp").forward(request, response);
								break;
							} else {
								request.setAttribute("access_wrong", true);
								getServletContext().getRequestDispatcher("/relogin.jsp").forward(request, response);
								break;
							}
						}
					}
				} else {
					getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (Exception e) {
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
}
