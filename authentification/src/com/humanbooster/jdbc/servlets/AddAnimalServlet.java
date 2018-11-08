package com.humanbooster.jdbc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.humanbooster.jdbc.dal.AnimalDAO;
import com.humanbooster.jdbc.model.Animal;
import com.humanbooster.jdbc.model.User;

/**
 * Servlet implementation class AddAnimalServlet
 */
@WebServlet("/coùnnected/user/AddAnimalServlet")
public class AddAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/addAnimal");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String strDangerous = request.getParameter("dangerous");
		Animal animal = new Animal(name, color, 
				Boolean.parseBoolean(strDangerous), 
				((User)request.getSession().getAttribute("user")).getIdUser());
		int status = AnimalDAO.getInstance().create(animal);
		if (status != 0) 
		{
			System.out.println("animal : " + animal + ", created.");
			response.sendRedirect(request.getContextPath()+"/connected/MyAnimalsServlet");
		}
		else 
		{
			request.setAttribute("errorMessage", "animal's name already used.");
			this.getServletContext()
				.getRequestDispatcher("/WEB-INF/addAnimal.jsp")
				.forward(request, response);
		}
	}
}
