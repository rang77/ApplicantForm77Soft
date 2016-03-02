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

		Resource result = resourceDAO.retrieveResouce(idNumber);
		
		HttpSession session = request.getSession();

		if (result != null) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/leave-management/getLeaveCredits");
			session.setAttribute("resourceId", result.getIdNumber());
//			request.setAttribute("employee", result);
			rd.forward(request, response);
		} else {
			response.sendRedirect("/leave-management/employeeNotFound.html");
		}
	}

}
