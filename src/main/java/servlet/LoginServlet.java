package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.force.api.ApiException;

import db.LoginDAO;
import db.ResourceDAO;
import model.Login;
import model.Resource;
import model.messages.PageMessages;
import utility.ContextKeys;
import utility.StringEncryptor;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "/login", urlPatterns = { "/login", "/leave-management/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ResourceDAO resourceDAO = (ResourceDAO) request.getServletContext().getAttribute(ContextKeys.RESOURCE_DAO);
		LoginDAO loginDAO = (LoginDAO) request.getServletContext().getAttribute(ContextKeys.LOGIN_DAO);
		HttpSession session = request.getSession();

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		PageMessages messages = new PageMessages();
		request.setAttribute("messages", messages);
		
		try {
			Login resourceLogin = loginDAO.retrieveLoginByEmail(email);

			if (resourceLogin == null) {
				messages.addErrorMessage("Username or Password is incorrect. Please try again.");
			} else {
				String hashedPassword = StringEncryptor.encryptString(password, resourceLogin.getSalt());
				
				if (!resourceLogin.getPassword().equals(hashedPassword)) {
					messages.addErrorMessage("Username or Password is incorrect. Please try again.");
				} else if (!resourceLogin.isActive()) {
					messages.addErrorMessage("Your account has been deactivated. Please contact your administrator.");
				} else if (resourceLogin.isAskForNewPassword()) {
					messages.addErrorMessage("Your account is not yet verified. Please check your email.");
				} else {
					// Check when user clicks "Forgot Password?" and enters his/her email address
					// but did not confirm the request
					if (resourceLogin.isForgotPassword()) {
						resourceLogin.setForgotPassword(false);
						resourceLogin.setForgotPasswordDate("");
						loginDAO.updateLogin(resourceLogin);
					}
					
					Resource retrievedResource = resourceDAO.retrieveResource(resourceLogin.getResource());
					session.setAttribute("recordId", retrievedResource.getId());
					response.sendRedirect("/leave-management/get-leave-credits");
					return;
				}
			}
		} catch (ApiException e) {
			messages.addErrorMessage("An error has occured. Please contact your administrator.");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

}
