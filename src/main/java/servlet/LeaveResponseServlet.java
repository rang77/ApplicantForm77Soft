package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.LeaveRequestDAO;
import model.LeaveRequest;
import model.error.PageError;
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
		String id = request.getParameter("id");
		String remarks = request.getParameter("remarks");
		String leaveStatus = request.getParameter("response");
		
		LeaveRequestDAO leaveRequestDAO = (LeaveRequestDAO) request.getServletContext().getAttribute(ContextKeys.LEAVE_REQUEST_DAO);
		RequestDispatcher rd = null;
		
		if(id != null && leaveStatus != null){
			
			LeaveRequest leaveRequest = leaveRequestDAO.retrieveRequestById(id);
			leaveRequest.setRemarks(remarks);
			leaveRequest.setLeaveStatus(leaveStatus);
			
			leaveRequestDAO.updateLeaveRequest(leaveRequest);
			
			String smessage = "Your response has been submitted. Thank you! �";
			
			request.setAttribute("smessage", smessage);
			rd = request.getRequestDispatcher("/leave-management/message.jsp");
		}else{
			PageError error = new PageError();
			error.setMessage("An error occured yea.");
			request.setAttribute("error",error);
			rd = request.getRequestDispatcher("/login.jsp");
		}
		rd.forward(request, response);
	}

}
