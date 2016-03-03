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
import javax.servlet.http.HttpServletResponse;

import model.error.SalesforceError;

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

		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
		String resourceId = null;
		
		if(req.getSession(false) != null){
			resourceId = (String) req.getSession(false).getAttribute("resourceId");
		}
		
		String uri = req.getRequestURI();
		String pageName = uri.substring(uri.lastIndexOf("/")+1);
		if (resourceId != null) {
			
			if(pageName.equals("viewLeave.jsp") || pageName.equals("login.jsp") || pageName.equals("LoginServlet") || pageName.equals("")){
				((HttpServletResponse)response).sendRedirect("/leave-management/getLeaveCredits");
			}else{
				chain.doFilter(request, response);
			}
			
		}else{			
			RequestDispatcher dispatch = req.getRequestDispatcher("/login.jsp");
			
			if(!(pageName.equals("login.jsp") || pageName.isEmpty())){
				if(pageName.equals("LoginServlet")){
					chain.doFilter(request, response);
					return;
				}else{
					SalesforceError error = new SalesforceError();
					error.setMessage("You need to login to access that page");
					req.setAttribute("error", error);
				}
			}
			
			dispatch.forward(req, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
