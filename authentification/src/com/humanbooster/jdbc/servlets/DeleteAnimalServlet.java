package com.humanbooster.jdbc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.humanbooster.jdbc.dal.AnimalDAO;

/**
 * Servlet implementation class DeleteAnimalServlet
 */
@WebServlet("/connected/user/DeleteAnimalServlet")
public class DeleteAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/myanimal.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnimalDAO.getInstance().delete(Integer.valueOf(request.getParameter("idAnimal")));
		doGet(request, response);
	}

}
