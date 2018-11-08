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
 * Servlet implementation class AnimalControlServlet
 */
@WebServlet("/connected/admin/AnimalsControlServlet")
public class AnimalsControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		java.util.List<Animal> animals = AnimalDAO.getInstance().getAll();
  		request.setAttribute("animals", animals);
  		this.getServletContext().getRequestDispatcher("/WEB-INF/animalscontrol.jsp")
  								.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnimalDAO.getInstance().delete(Integer.valueOf(request.getParameter("idAnimal")));
		doGet(request, response);
	}
}
