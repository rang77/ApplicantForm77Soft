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
import model.error.PageError;

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		if (email != null && !email.isEmpty()) {
			LoginDAO loginDao = new LoginDAO();
			
			Login login = loginDao.retrieveLoginByEmail(email);
			
			if (login != null) {
				login.setForgotPassword(true);
				loginDao.updateLogin(login);
			}
			
			request.setAttribute("smessage", "Message sent! Please check your email for the instructions on how to confirm your request.");
			
			RequestDispatcher rd = request.getRequestDispatcher("/leave-management/message.jsp");
			rd.forward(request, response);
		} else {
			PageError error = new PageError();
			error.setMessage("Invalid email.");
			request.setAttribute("error", error);
			
			RequestDispatcher rd = request.getRequestDispatcher("/leave-management/forgotPassword.jsp");
			rd.forward(request, response);
		}
	}

}
