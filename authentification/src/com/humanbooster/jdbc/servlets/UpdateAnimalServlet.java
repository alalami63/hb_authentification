package com.humanbooster.jdbc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.humanbooster.jdbc.dal.AnimalDAO;
import com.humanbooster.jdbc.model.Animal;

/**
 * Servlet implementation class UpdateAnimalServlet
 */
@WebServlet("/connected/user/UpdateAnimalServlet")
public class UpdateAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-IN/updateanimal.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Animal animal = AnimalDAO
						.getInstance()
						.get(Integer.valueOf(request.getParameter("idAnimal")));
		request.setAttribute("animal", animal);
		doGet(request, response);
	}
}
