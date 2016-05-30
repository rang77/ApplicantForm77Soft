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

import db.LoginDAO;
import helper.ServletHelper;
import model.Resource;

import model.Login;
import model.error.PageError;
import utility.StringEncryptor;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "/LoginServlet", urlPatterns = { "/LoginServlet", "/leave-management/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		ResourceDAO resourceDAO = new ResourceDAO();
		LoginDAO loginDAO = new LoginDAO();
		HttpSession session = request.getSession();

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			Login resourceLogin = loginDAO.retrieveLoginByEmail(email);

			if (resourceLogin == null) {
				PageError error = new PageError();
				error.setMessage("Username or Password is incorrect. Please try again.");
				request.setAttribute("error", error);
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");

				rd.forward(request, response);
				
				return;
			}

			String hashedPassword = StringEncryptor.encryptString(password, resourceLogin.getSalt());

			if (resourceLogin.getPassword().equals(hashedPassword)) {
				Resource retrievedResource = resourceDAO.retrieveResource(resourceLogin.getResource());

				RequestDispatcher rd = request.getRequestDispatcher("/leave-management/getLeaveCredits");
				session.setAttribute("recordId", retrievedResource.getId());
				session.setAttribute("resourceId", retrievedResource.getIdNumber());
				rd.forward(request, response);
			} else {
				PageError error = new PageError();
				error.setMessage("Username or Password is incorrect. Please try again.");
				request.setAttribute("error", error);
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");

				rd.forward(request, response);
			}
		} catch (ApiException e) {
			PageError error = ServletHelper.handleAPIException(e.getMessage());

			if (error != null) {
				request.setAttribute("error", error);
			}

			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");

			rd.forward(request, response);
		}
	}

}
