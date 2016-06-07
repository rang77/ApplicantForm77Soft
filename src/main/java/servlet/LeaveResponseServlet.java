package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.force.api.ApiException;

import db.LeaveRequestDAO;
import helper.ServletHelper;
import model.LeaveRequest;
import model.error.PageError;
import model.messages.PageMessages;
import utility.ContextKeys;

/**
 * Servlet implementation class LeaveResponseServlet
 */
@WebServlet("/leave-management/submit-leave-response")
public class LeaveResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveResponseServlet() {
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
		String id = request.getParameter("id");
		String remarks = request.getParameter("remarks");
		String leaveStatus = request.getParameter("response");
		
		LeaveRequestDAO leaveRequestDAO = (LeaveRequestDAO) request.getServletContext().getAttribute(ContextKeys.LEAVE_REQUEST_DAO);
		RequestDispatcher rd = null;

		PageMessages messages = new PageMessages();
		request.setAttribute("messages", messages);
		
		if(id != null && leaveStatus != null){
			try {
				LeaveRequest leaveRequest = leaveRequestDAO.retrieveRequestById(id);
				leaveRequest.setRemarks(remarks);
				leaveRequest.setLeaveStatus(leaveStatus);
				
				leaveRequestDAO.updateLeaveRequest(leaveRequest);
				
				messages.addSuccessMessage("Your response has been submitted. Thank you!");
				rd = request.getRequestDispatcher("/leave-management/message.jsp");
			} catch (ApiException e) {
				PageError pageError = ServletHelper.handleAPIException(e.getMessage());
				System.err.println(pageError.getErrorCode());
				System.err.println(pageError.getMessage());
				if ("FIELD_CUSTOM_VALIDATION_EXCEPTION".equals(pageError.getErrorCode())) {
					messages.addErrorMessage(pageError.getMessage());
				} else {
					messages.addErrorMessage("An error has occured.");
				}
				rd = request.getRequestDispatcher("/leave-management/approveLeaveRequest.jsp");
			}
		}else{
			messages.addErrorMessage("An error occured.");
			rd = request.getRequestDispatcher("/login.jsp");
		}
		rd.forward(request, response);
	}

}
