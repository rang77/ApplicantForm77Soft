package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.LoginDAO;
import model.Login;
import model.messages.PageMessages;
import utility.ContextKeys;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/leave-management/forgot-password")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.sendRedirect("/login.jsp");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		PageMessages messages = new PageMessages();
		request.setAttribute("messages", messages);
		
		if (email != null && !email.isEmpty()) {
			LoginDAO loginDao = (LoginDAO) request.getServletContext().getAttribute(ContextKeys.LOGIN_DAO);
			
			Login login = loginDao.retrieveLoginByEmail(email);
			
			if (login != null && login.isActive()) {
				login.setForgotPassword(true);
				loginDao.updateLogin(login);
			}
			
			messages.addSuccessMessage("Message sent! Please check your email for the instructions on how to confirm your request.");
			
			RequestDispatcher rd = request.getRequestDispatcher("/leave-management/message.jsp");
			rd.forward(request, response);
		} else {
			messages.addErrorMessage("Invalid email.");
			
			RequestDispatcher rd = request.getRequestDispatcher("/leave-management/forgotPassword.jsp");
			rd.forward(request, response);
		}
	}

}
