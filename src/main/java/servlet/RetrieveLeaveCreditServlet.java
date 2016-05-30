package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.ResourceDAO;
import model.Resource;

@WebServlet(name = "retrieveLeaveCreditServlet", urlPatterns = {"/leave-management/viewLeave", "/leave-management/getLeaveCredits/*", "/leave-management/getLeaveCredits" })
//@WebServlet(name = "/RetrieveLeaveCreditServlet")
public class RetrieveLeaveCreditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
	}
	
	private void getLeaveDetails(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		ResourceDAO resourceDAO = new ResourceDAO();
		
		HttpSession session = request.getSession();
		
		String resourceId = (String) session.getAttribute("recordId");

		Resource result = resourceDAO.retrieveResource(resourceId);
		
		if (result != null) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/leave-management/viewLeave.jsp");
			request.setAttribute("employee", result);
			rd.forward(request, response);
		} else {
			request.setAttribute("error", true);
			RequestDispatcher rd = request
					.getRequestDispatcher(request.getRequestURI());
			
			rd.forward(request, response);
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
