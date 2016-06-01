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
import utility.ContextKeys;
import utility.StringEncryptor;

/**
 * Servlet implementation class CreateNewPasswordServlet
 */
@WebServlet("/leave-management/create-new-password")
public class CreateNewPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		String id = request.getParameter("loginid");
		
		if(id == null){
			response.sendRedirect("/login.jsp");
			return;
		}
		
		String activationCode = request.getParameter("activation");
		String newpassword = request.getParameter("newpassword1");
		
		Login tempLogin = loginDAO.retrieveLoginById(id);
		RequestDispatcher rd = request.getRequestDispatcher("/leave-management/prompt-new-password?id="+id);
		
		System.out.println(request.getRequestURI());
		if(tempLogin.getActivationCode().equals(activationCode)){
			System.out.println("activation code ok");
			newpassword = StringEncryptor.encryptString(newpassword, tempLogin.getSalt());
			
			tempLogin.setPassword(newpassword);
			tempLogin.setAskForNewPassword(false);
			
			try{
				loginDAO.updateLogin(tempLogin);
				
				String smessage = "Update Successful. Please try logging in with your new credentials.";
				request.setAttribute("smessage", smessage);
				
				rd = request.getRequestDispatcher("/login.jsp");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}else{
			System.out.println("activation code not ok");
			PageError error = new PageError();
			error.setMessage("Invalid Activation Code.");
			request.setAttribute("error", error);
		}
		
		rd.forward(request, response);
	}

}
