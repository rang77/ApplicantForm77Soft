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

import db.ResourceDAO;
import helper.ServletHelper;
import model.Resource;
import model.error.SalesforceError;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResourceDAO resourceDAO = new ResourceDAO();
		
		String idNumber = request.getParameter("idNumber");
		HttpSession session = request.getSession();
		
		if(idNumber.isEmpty()){
			SalesforceError error = new SalesforceError();
			error.setMessage("Employee does not exist.");
			request.setAttribute("error", error);
			RequestDispatcher rd = request
					.getRequestDispatcher("/login.jsp");
			
			rd.forward(request, response);
		}
		
		try{
			Resource result = resourceDAO.retrieveResouce(idNumber);	
			
			if (result != null) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/leave-management/getLeaveCredits");
				session.setAttribute("recordId", result.getRecordID());
				session.setAttribute("resourceId", result.getIdNumber());
				rd.forward(request, response);
			} else {
				SalesforceError error = new SalesforceError();
				error.setMessage("Employee does not exist.");
				request.setAttribute("error", error);
				RequestDispatcher rd = request
						.getRequestDispatcher("/login.jsp");
				
				rd.forward(request, response);
			}
		}catch(ApiException e){
			SalesforceError error = ServletHelper.handleAPIException(e.getMessage());
			
			if(error != null){
				request.setAttribute("error", error);
			}			
			
			RequestDispatcher rd = request
					.getRequestDispatcher("/login.jsp");
			
			rd.forward(request, response);			
		}
	}

}
