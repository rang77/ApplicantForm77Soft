package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.LeaveRequestDAO;
import db.ResourceDAO;
import model.LeaveRequest;
import model.Resource;
import model.error.PageError;

/**
 * Servlet implementation class ConfirmApprovalCodeServlet
 */
@WebServlet("/leave-management/ConfirmVerificationCode")
public class ConfirmVerificationCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmVerificationCodeServlet() {
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
		String type = request.getParameter("type");
		String code = request.getParameter("verification");
		
		if(id != null && type != null && code != null){
			RequestDispatcher rd = null;
			
			if("LeaveRequest__c".equals(type)){
				LeaveRequestDAO leaveRequestDao = new LeaveRequestDAO();
				ResourceDAO resourceDao = new ResourceDAO();
				
				LeaveRequest leaveRequest = leaveRequestDao.retrieveRequestById(id);
				
				Resource resource = resourceDao.retrieveResourceApprovalDetails(leaveRequest.getEmployeeID(), leaveRequest);
				
				request.setAttribute("employee", resource);
				request.setAttribute("leave", leaveRequest);
				request.setAttribute("id", id);
				
				rd = request.getRequestDispatcher("/leave-management/approveLeaveRequest.jsp");
				
			}else{
				response.sendRedirect("/login.jsp");
			}
			
			rd.forward(request, response);
			
		}else{
			PageError error = new PageError();
			error.setMessage("Invalid code.");
			request.setAttribute("error", error);
			
			RequestDispatcher rd = request.getRequestDispatcher("/leave-management/confirmActivationCode.jsp");
			rd.forward(request, response);
		}
		
	}

}
