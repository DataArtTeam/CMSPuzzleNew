package servlets;

import access.UserRole;
import access.UserStatus;
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

@WebServlet(description = "to register a new user", urlPatterns = { "/registration" })
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HibernateFactory hibernateFactory = HibernateFactory.getInstance();
	UserDao userDao = hibernateFactory.getUserDao();

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String login = request.getParameter("login");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("password_confirmation");
//		String role = request.getParameter("role");
		UserRole role = UserRole.USER;
		UserStatus status = UserStatus.AVAILABLE;
		System.out.println("Registration servlet working...");
		
		request.setAttribute("firstname", firstName);
		request.setAttribute("lastname", lastName);
		if ((login == "") || (login == null) || (password == "")
				|| (password == null)  || (firstName == "")
				|| (firstName == null) || (lastName == "")
				|| (lastName == null)  || (email == null) 
//				|| (role == null)
				){
			getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
			return;
		}
		if (!password.equals(passwordConfirm)){
			getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
			return;
		}
		try {
			List<User> users = userDao.getUsers();
			for (User user : users) {
				if (user.getLogin().equals(login))
					getServletContext().getRequestDispatcher("/relogin.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		User newUser = new User();
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setLogin(login);
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setRole(role);
		newUser.setStatus(status);
		
		try {
			userDao.addUser(newUser);
			System.out.println("New user was saved in database");
			getServletContext().getRequestDispatcher("/successLogin.jsp").forward(request, response);
//			new SendMessage().sendMessage("Diesel31ks@mail.ru", "confirmation", "you need to confirm you registration");
		} catch (SQLException e) {
			e.printStackTrace();
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);	
//		} catch (MessagingException e) {
//			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
