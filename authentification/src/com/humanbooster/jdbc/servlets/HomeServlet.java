package com.humanbooster.jdbc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.humanbooster.jdbc.model.User;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/connected/HomeServlet")
public class HomeServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		if (((User)request.getSession()
							.getAttribute("user"))
							.getLogin()
							.equals("admin"))
		{
			this.getServletContext().getRequestDispatcher("/connected/admin/HomeAdminServlet").forward(request, response);
		}
		else
		{
			this.getServletContext().getRequestDispatcher("/connected/user/HomeUserServlet").forward(request, response);
		}
	}
}
