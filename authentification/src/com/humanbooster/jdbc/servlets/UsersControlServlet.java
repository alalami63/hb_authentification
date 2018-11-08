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
 * Servlet implementation class UsersControlServlet
 */
@WebServlet("/connected/admin/UsersControlServlet")
public class UsersControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		java.util.List<User> users = UserDAO.getInstance().getAll();
  		request.setAttribute("users", users);
  		this.getServletContext().getRequestDispatcher("/WEB-INF/userscontrol.jsp")
  								.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO.getInstance().delete(request.getParameter("login"));
		doGet(request, response);
	}

}
