package filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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

import model.error.PageError;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter("/SessionFilter")
public class SessionFilter implements Filter {

	private static Set<String> whiteListNoSession;
	private static Set<String> whiteList;
	
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
			resourceId = (String) req.getSession(false).getAttribute("recordId");
		}
		
		String uri = req.getRequestURI();
		String pageName = uri.substring(uri.lastIndexOf("/")+1);
		
		System.out.println(pageName);
		
		if (resourceId != null) {
			
			if(whiteList.contains(pageName)){
				((HttpServletResponse)response).sendRedirect("/leave-management/getLeaveCredits");
			}else{
				chain.doFilter(request, response);
			}
			
		}else{			
			RequestDispatcher dispatch = req.getRequestDispatcher("/login.jsp");
			
			if(!(pageName.equals("login.jsp") || pageName.isEmpty())){
				if(whiteListNoSession.contains(pageName)){
					chain.doFilter(request, response);
					return;
				}else{
					PageError error = new PageError();
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
		whiteListNoSession = new HashSet<>();
		
		whiteListNoSession.add("leaveRequestApproval");
		whiteListNoSession.add("ConfirmVerificationCode");
		whiteListNoSession.add("LoginServlet");
		whiteListNoSession.add("promptNewPassword");
		whiteListNoSession.add("CreateNewPasswordServlet");
		whiteListNoSession.add("submitLeaveResponse");
		whiteListNoSession.add("forgot-password");
		whiteListNoSession.add("forgotPassword.jsp");
		whiteListNoSession.add("forgot-password-confirmation");
		
		whiteList = new HashSet<>();
		whiteList.add("viewLeave.jsp");
		whiteList.add("login.jsp");
		whiteList.add("promptNewPassword.jsp");
		whiteList.add("LoginServlet");
		whiteList.add("");
	}
}
