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

import model.messages.PageMessages;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter("/SessionFilter")
public class SessionFilter implements Filter {

	private static Set<String> noSessionWhiteList;
	private static Set<String> sessionBlackList;
	
	/**
	 * Default constructor.
	 */
	public SessionFilter() {}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {}

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
		
		if (resourceId != null) {
			
			if(sessionBlackList.contains(pageName)){
				((HttpServletResponse)response).sendRedirect("/leave-management/get-leave-credits");
			}else{
				chain.doFilter(request, response);
			}
			
		}else{			
			RequestDispatcher dispatch = req.getRequestDispatcher("/login.jsp");
			
			if(!(pageName.equals("login.jsp") || pageName.isEmpty())){
				if(noSessionWhiteList.contains(pageName)){
					chain.doFilter(request, response);
					return;
				}else{
					PageMessages messages = new PageMessages();
					messages.addErrorMessage("You need to login to access that page");
					req.setAttribute("messages", messages);
				}
			}
			
			dispatch.forward(req, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		noSessionWhiteList = new HashSet<>();
		
		noSessionWhiteList.add("leave-request-approval");
		noSessionWhiteList.add("confirm-verification-code");
		noSessionWhiteList.add("login");
		noSessionWhiteList.add("prompt-new-password");
		noSessionWhiteList.add("create-new-password");
		noSessionWhiteList.add("submit-leave-response");
		noSessionWhiteList.add("forgot-password");
		noSessionWhiteList.add("forgotPassword.jsp");
		noSessionWhiteList.add("forgot-password-confirmation");
		
		sessionBlackList = new HashSet<>();
		sessionBlackList.add("viewLeave.jsp");
		sessionBlackList.add("login.jsp");
		sessionBlackList.add("promptNewPassword.jsp");
		sessionBlackList.add("login");
		sessionBlackList.add("confirmActivationCode.jsp");
		sessionBlackList.add("approveLeaveRequest.jsp");
		sessionBlackList.add("forgotPassword.jsp");
		sessionBlackList.add("forgot-password-confirmation");
		sessionBlackList.add("");
	}
}
