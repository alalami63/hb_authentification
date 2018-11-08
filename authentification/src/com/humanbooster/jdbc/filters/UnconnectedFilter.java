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

/**
 * Servlet Filter implementation class Unconnected
 */
@WebFilter("/unconnected/*")
public class UnconnectedFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		if (req.getSession().getAttribute("user") != null)
		{
			resp.sendRedirect(req.getContextPath()+"/connected/HomeServlet");
		}
		else
		{
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}
}
