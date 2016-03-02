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

import db.LeaveRequestDAO;
import helper.ServletHelper;
import model.LeaveRequest;
import model.error.SalesforceError;

@WebServlet(name = "fileLeaveServlet", urlPatterns = {"/leave-management/fileLeave/*","/leave-management/fileLeave" })
public class FileLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaveRequestDAO leaveRequestDAO = new LeaveRequestDAO();
		
		HttpSession session = request.getSession();
		
		String recordId = (String) session.getAttribute("recordId");
		String leaveType = request.getParameter("leaveType");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String reason = request.getParameter("leaveReason");
		
		LeaveRequest leaveRequest = new LeaveRequest();
		
		leaveRequest.setEmployeeID(recordId);
		leaveRequest.setLeaveType(leaveType);
		leaveRequest.setStartDate(startDate);
		leaveRequest.setEndDate(endDate);
		leaveRequest.setReason(reason);
		
		try{
			String requestID = leaveRequestDAO.createLeaveRequest(leaveRequest);
			if(requestID != null){
				response.sendRedirect("/leave-management/getLeaveCredits");
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/leave-management/fileLeave.jsp");
				rd.forward(request, response);				
				SalesforceError error = new SalesforceError();
				error.setMessage("An error has occurred.");
				
				request.setAttribute("error", error);
				rd.forward(request, response);
			}
			
		}catch(ApiException e){
			SalesforceError error = ServletHelper.handleAPIException(e.getMessage());
			if(error != null){
				request.setAttribute("error", error);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/leave-management/fileLeave.jsp");
			rd.forward(request, response);
		}
		
	}
}
