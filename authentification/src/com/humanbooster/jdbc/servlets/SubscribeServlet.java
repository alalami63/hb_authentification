package com.humanbooster.jdbc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.humanbooster.jdbc.dal.UserDAO;
import com.humanbooster.jdbc.model.User;

/**
 * Servlet implementation class SubscribeServlet
 */
@WebServlet("/unconnected/SubscribeServlet")
public class SubscribeServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/subscribe.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("Access " + getServletName() + " POST ");
		String login = request.getParameter("login")
								.trim()
								.toLowerCase();
		String password = request.getParameter("password");
		String fname = request.getParameter("fname")
								.trim();
		String finalFname = fname.substring(0, 1)
									.toUpperCase() 
							+ fname.substring(1)
									.toLowerCase();
		String lname = request.getParameter("lname")
								.trim();
		String finalLname = lname.substring(0, 1)
									.toUpperCase() 
							+ lname.substring(1)
									.toLowerCase();
		User user = new User(finalFname, finalLname, login, password);
		int status = UserDAO.getInstance()
								.create(user);
		if (status == 1) {
			System.out.println("User : " + user + ", created.");
			request.setAttribute("user", user);
			this.getServletContext()
				.getRequestDispatcher("/WEB-INF/login.jsp")
				.forward(request, response);
		}
		else {
			request.setAttribute("errorMessage", "Login already used.");
			this.getServletContext()
				.getRequestDispatcher("/WEB-INF/subscribe.jsp")
				.forward(request, response);
		}
	}
}
