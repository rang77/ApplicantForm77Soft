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

/**
 * Servlet implementation class PromptNewPassword
 */
@WebServlet("/leave-management/promptNewPassword")
public class PromptNewPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PromptNewPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDAO loginDAO = new LoginDAO();
		String id = request.getParameter("id");
		
		if(id != null){
			Login tempLogin = loginDAO.retrieveLoginById(id);
			
			if(tempLogin != null && tempLogin.isAskForNewPassword()){
				System.out.println(tempLogin.toString());
				
				RequestDispatcher rd = request.getRequestDispatcher("/promptNewPassword.jsp");
				request.setAttribute("login", tempLogin);
				rd.forward(request, response);
				
				return;
			}
		}
		
		response.sendRedirect("/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/login.jsp");
	}

}
