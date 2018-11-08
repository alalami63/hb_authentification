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
 * Servlet implementation class ConnectionServlet
 */
@WebServlet("/unconnected/ConnectionServlet")
public class ConnectionServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/login.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login")
								.trim()
								.toLowerCase();
		String password = request.getParameter("password");
	
		User user = UserDAO.getInstance().get(login);
		if (user != null
				&& user.getPassword().equals(password))
		{
			request.getSession()
					.setAttribute("user", user);
			response.sendRedirect(getServletContext().getContextPath()+"/connected/HomeServlet");
//			this.getServletContext()
//				.getRequestDispatcher("/WEB-INF/home.jsp")
//				.forward(request, response);
		}
		else
		{
			request.setAttribute("errorMessage", "Please check your login and password.");
			this.getServletContext()
				.getRequestDispatcher("/WEB-INF/login.jsp")
				.forward(request, response);
		}
	}
}
