package com.humanbooster.jdbc.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.humanbooster.jdbc.model.User;

/**
 * Servlet Filter implementation class Admin
 */
@WebFilter("/connected/admin/*")
public class AdminFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if (((User)(req.getSession()
						.getAttribute("user")))
						.getLogin()
						.equals("admin"))
		{
			chain.doFilter(request, response);
		}
		else
		{
			res.sendRedirect(req.getContextPath()+"/home");
		}		
	}
}
