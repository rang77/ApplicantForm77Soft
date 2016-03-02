package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import db.ResourceDAO;
import model.Resource;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter("/SessionFilter")
public class SessionFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SessionFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
		String resourceId = null;
		
		if(req.getSession(false) != null){
			resourceId = (String) req.getSession(false).getAttribute("resourceId");
		}
		
		if (resourceId != null) {
			String uri = req.getRequestURI();
			
			String pageName = uri.substring(uri.lastIndexOf("/")+1);
			
			if(pageName.equals("viewLeave.jsp") || pageName.equals("login.jsp")){
				RequestDispatcher dispatch = req.getRequestDispatcher("/leave-management/getLeaveCredits");	
				dispatch.forward(request, response);
			}else{
				chain.doFilter(request, response);
			}
		}else{			
			RequestDispatcher dispatch = req.getRequestDispatcher("/login.jsp");
			dispatch.forward(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
