package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.LoginDAO;
import model.Login;
import model.error.PageError;
import utility.ContextKeys;
import utility.StringEncryptor;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/leave-management/change-password")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDAO loginDAO = (LoginDAO) request.getServletContext().getAttribute(ContextKeys.LOGIN_DAO);
		HttpSession session = request.getSession();
		
		String resourceId = (String)session.getAttribute("recordId");
		
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword1");
		RequestDispatcher rd = request.getRequestDispatcher("/leave-management/changePassword.jsp");
		
		try{
			Login tempLogin = loginDAO.retrieveLoginByResource(resourceId);
			oldpassword = StringEncryptor.encryptString(oldpassword, tempLogin.getSalt());
			
			if(tempLogin.getPassword().equals(oldpassword)){
				newpassword = StringEncryptor.encryptString(newpassword, tempLogin.getSalt());
				
				tempLogin.setPassword(newpassword);
				loginDAO.updateLogin(tempLogin);
				String smessage = "Password has been successfully updated.";
				request.setAttribute("smessage", smessage);

				rd = request.getRequestDispatcher("/leave-management/get-leave-credits");
			}else{
				PageError error = new PageError();
				
				error.setMessage("Old Password is invalid. Please try again.");
				request.setAttribute("error", error);
			}
		}catch(Exception e){
			PageError error = new PageError();
			error.setMessage("Error 500: " + e.getMessage());
			
			request.setAttribute("error", error);
		}
		
		rd.forward(request, response);
	}
}
