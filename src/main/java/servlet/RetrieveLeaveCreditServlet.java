package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ResourceDAO;
import model.Resource;

@WebServlet(name = "retrieveLeaveCreditServlet", urlPatterns = {"/leave-management/getLeaveCredits/*", "/leave-management/getLeaveCredits" })
public class RetrieveLeaveCreditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
	}
	
	private void getLeaveDetails(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		ResourceDAO resourceDAO = new ResourceDAO();
		
		String idNumber = request.getParameter("idNumber");

		Resource result = resourceDAO.retrieveResouce(idNumber);

		if (result != null) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/leave-management/viewLeave.jsp");
			request.setAttribute("employee", result);
			rd.forward(request, response);
		} else {
			response.sendRedirect("/leave-management/employeeNotFound.html");
		}
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getLeaveDetails(request,response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getLeaveDetails(request,response);
	}

}
