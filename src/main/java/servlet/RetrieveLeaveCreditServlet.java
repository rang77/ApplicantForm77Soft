package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.SalesforceDAO;
import model.Employee;

@WebServlet(name = "retrieveLeaveCreditServlet", urlPatterns = {"/leave-management/getLeaveCredits/*", "/leave-management/getLeaveCredits" })
public class RetrieveLeaveCreditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
	}
	
	private void getLeaveDetails(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		SalesforceDAO<Employee> connector = new SalesforceDAO<Employee>();
		
		connector.connect();

		String idNumber = request.getParameter("idNumber");

		List<Employee> result = connector.retrieve(String.format(
				"SELECT id,Name,IDNumber__c,FirstName__c,"
						+ "LastName__c,MiddleName__c,SLCredits__c,"
						+ "UsedSLCredits__c,UsedVLCredits__c,VLCredits__c,"
							+ "(SELECT Name, LeaveType__c,StartDate__c,EndDate__c,DaysOnLeave__c,"
							+ "CreatedDate FROM LeaveRequests__r ORDER BY CreatedDate DESC)"
						+ " FROM Employee__c WHERE IDNumber__c LIKE '%s'",
				idNumber), Employee.class);

		if (result.size() == 0) {
			response.sendRedirect("/leave-management/employeeNotFound.html");
		} else {
			Employee employee = result.get(0);
			
			RequestDispatcher rd = request
					.getRequestDispatcher("/leave-management/viewLeave.jsp");
			request.setAttribute("employee", employee);
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
