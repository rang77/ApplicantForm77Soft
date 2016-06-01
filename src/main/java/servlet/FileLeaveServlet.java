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
import model.error.PageError;
import utility.ContextKeys;

@WebServlet(name = "file-leave", urlPatterns = {"/leave-management/file-leave/*","/leave-management/file-leave" })
public class FileLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaveRequestDAO leaveRequestDAO = (LeaveRequestDAO) request.getServletContext().getAttribute(ContextKeys.LEAVE_REQUEST_DAO);
		
		HttpSession session = request.getSession();
		
		String recordId = (String) session.getAttribute("recordId");
		String leaveType = request.getParameter("leaveType");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String reason = request.getParameter("leaveReason");
		boolean halfday = request.getParameter("halfday") != null;
		
		LeaveRequest leaveRequest = new LeaveRequest();
		
		leaveRequest.setEmployeeID(recordId);
		leaveRequest.setLeaveType(leaveType);
		leaveRequest.setStartDate(startDate);
		leaveRequest.setEndDate(endDate);
		leaveRequest.setEndDate(endDate);
		leaveRequest.setReason(reason);
		leaveRequest.setHalfday(halfday);
		leaveRequest.setLeaveStatus("Pending");
		
		try{
			String requestID = leaveRequestDAO.createLeaveRequest(leaveRequest);
			if(requestID != null){
				RequestDispatcher rd = request.getRequestDispatcher("/leave-management/get-leave-credits");
				
				request.setAttribute("smessage", "Request leave successful. Please wait while the request is pending for approval.");
				rd.forward(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/leave-management/fileLeave.jsp");
				PageError error = new PageError();
				error.setMessage("An error has occurred.");
				
				request.setAttribute("leaveType",leaveType);
				request.setAttribute("startDate",startDate);
				request.setAttribute("endDate",endDate);
				request.setAttribute("reason",reason);
				request.setAttribute("halfday",halfday);
				request.setAttribute("error", error);
				rd.forward(request, response);
			}
			
		}catch(ApiException e){
			PageError error = ServletHelper.handleAPIException(e.getMessage());
			if(error != null){
				request.setAttribute("error", error);
			}
			
			request.setAttribute("leaveType",leaveType);
			request.setAttribute("startDate",startDate);
			request.setAttribute("endDate",endDate);
			request.setAttribute("reason",reason);
			request.setAttribute("halfday",halfday);
			RequestDispatcher rd = request.getRequestDispatcher("/leave-management/fileLeave.jsp");
			rd.forward(request, response);
		}
		
	}
}
