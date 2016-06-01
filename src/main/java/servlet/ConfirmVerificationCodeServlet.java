package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.LeaveRequestDAO;
import db.LoginDAO;
import db.ResourceDAO;
import model.LeaveRequest;
import model.Login;
import model.Resource;
import model.messages.PageMessages;
import utility.ContextKeys;

/**
 * Servlet implementation class ConfirmApprovalCodeServlet
 */
@WebServlet("/leave-management/confirm-verification-code")
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
		
		PageMessages messages = new PageMessages();
		request.setAttribute("messages", messages);
		
		if(id != null && type != null && code != null && !id.isEmpty() && !type.isEmpty() && !code.isEmpty()){
			RequestDispatcher rd = null;
			
			if("LeaveRequest__c".equals(type)){
				LeaveRequestDAO leaveRequestDao = (LeaveRequestDAO) request.getServletContext().getAttribute(ContextKeys.LEAVE_REQUEST_DAO);
				ResourceDAO resourceDao = (ResourceDAO) request.getServletContext().getAttribute(ContextKeys.RESOURCE_DAO);
				
				LeaveRequest leaveRequest = leaveRequestDao.retrieveRequestById(id);
				
				Resource resource = resourceDao.retrieveResourceApprovalDetails(leaveRequest.getEmployeeID(), leaveRequest);
				
				request.setAttribute("employee", resource);
				request.setAttribute("leave", leaveRequest);
				request.setAttribute("id", id);
				
				rd = request.getRequestDispatcher("/leave-management/approveLeaveRequest.jsp");
			} else if ("forgot-password".equals(type)) {
				LoginDAO loginDao = (LoginDAO) request.getServletContext().getAttribute(ContextKeys.LOGIN_DAO);
				Login login = loginDao.retrieveLoginById(id);
				
				if (login != null) {
					if (code.equals(login.getActivationCode())) {
						login.setForgotPassword(false);
						login.setForgotPasswordDate(null);
						login.setAskForNewPassword(true);
						
						loginDao.updateLogin(login);
						
						messages.addSuccessMessage("Request for change of password successfully confirmed! "
												+ "Please check your email for the instructions on how to set a new password.");
						rd = request.getRequestDispatcher("/leave-management/message.jsp");
					} else {
						messages.addErrorMessage("Invalid verification code.");
						rd = request.getRequestDispatcher("/leave-management/confirmActivationCode.jsp");
					}
				} else {
					messages.addErrorMessage("Invalid login account.");
					rd = request.getRequestDispatcher("/leave-management/confirmActivationCode.jsp");
				}

			} else {
				response.sendRedirect("/login.jsp");
				return;
			}

			rd.forward(request, response);
		}else{
			messages.addErrorMessage("Invalid code.");
			
			RequestDispatcher rd = request.getRequestDispatcher("/leave-management/confirmActivationCode.jsp");
			rd.forward(request, response);
		}
		
	}

}
