package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.LeaveRequestDAO;
import db.ResourceDAO;
import model.LeaveRequest;
import model.Resource;

/**
 * Servlet implementation class LeaveRequestApprovalServlet
 */
@WebServlet("/leave-management/leaveRequestApproval")
public class LeaveRequestApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveRequestApprovalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaveRequestDAO leaveRequestDAO = new LeaveRequestDAO();
		ResourceDAO resourceDAO = new ResourceDAO();
		String id = request.getParameter("id");
		
		if(id != null){
			LeaveRequest leaveRequest = leaveRequestDAO.retrieveRequestById(id);
			
			if(leaveRequest != null){
				
				Resource resource = resourceDAO.retrieveResourceApprovalDetails(leaveRequest.getEmployeeID(), leaveRequest);
				
				request.setAttribute("employee", resource);
				request.setAttribute("leave", leaveRequest);
				request.getRequestDispatcher("/leave-management/approveLeaveRequest.jsp").forward(request, response);
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
