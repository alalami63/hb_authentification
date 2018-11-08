package com.humanbooster.jdbc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.humanbooster.jdbc.dal.UserDAO;
import com.humanbooster.jdbc.model.Animal;
import com.humanbooster.jdbc.model.User;

/**
 * Servlet implementation class PersInfosServlet
 */
@WebServlet("/connected/user/MyAnimalsServlet")
public class MyAnimalsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		java.util.List<Animal> animals = UserDAO.getInstance()
				.getAnimals(((User)(request.getSession()
						.getAttribute("user")))
						.getLogin());
		request.setAttribute("animals", animals);
		this.getServletContext().getRequestDispatcher("/WEB-INF/myanimals.jsp")
																.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
