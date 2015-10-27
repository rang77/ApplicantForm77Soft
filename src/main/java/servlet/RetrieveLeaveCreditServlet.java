package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.force.api.ApiConfig;
import com.force.api.ForceApi;
import com.force.api.QueryResult;

import model.Employee;

@WebServlet(name = "retrieveLeaveCreditServlet", urlPatterns = {
		"/leave-management/getLeaveCredits/*",
		"/leave-management/getLeaveCredits" }, initParams = {
				// clientId is 'Consumer Key' in the Remote Access UI
				@WebInitParam(name = "clientId", value = "3MVG9ZL0ppGP5UrC9R5pfGadp9_.sezTYM4KyOofpmNB9S0IumaT57vNAI1j0Xbl6fJInNkjvcIDSCKZ9ypMm"),
				// clientSecret is 'Consumer Secret' in the Remote Access UI
				@WebInitParam(name = "clientSecret", value = "8568904816664843552"),
				// This must be identical to 'Callback URL' in the Remote Access
				// UI
				@WebInitParam(name = "environment", value = "https://login.salesforce.com"), })
public class RetrieveLeaveCreditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String USERNAME = "devorg@77soft.com";
	private static final String PASSWORD = "77GSIDev";
	private static final String SECURITY_TOKEN = "ta3WbXLee49bAgxiiepNipmA";
	private String clientId = null;
	private String clientSecret = null;
	private String environment = null;

	public void init() throws ServletException {
		clientId = this.getInitParameter("clientId");
		clientSecret = this.getInitParameter("clientSecret");
		environment = this.getInitParameter("environment");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ApiConfig config = new ApiConfig();
		config.setUsername(USERNAME);
		config.setPassword(PASSWORD + SECURITY_TOKEN);
		config.setClientId(clientId);
		config.setClientSecret(clientSecret);
		config.setLoginEndpoint(environment);

		ForceApi api = new ForceApi(config);

		String idNumber = request.getParameter("idNumber");

		QueryResult<Employee> result = api.query(String.format(
				"SELECT id,Name,IDNumber__c,FirstName__c,"
						+ "LastName__c,MiddleName__c,SLCredits__c,"
						+ "UsedSLCredits__c,UsedVLCredits__c,VLCredits__c,"
							+ "(SELECT Name, LeaveType__c,StartDate__c,EndDate__c,DaysOnLeave__c,"
							+ "CreatedDate FROM LeaveRequests__r ORDER BY CreatedDate DESC)"
						+ " FROM Employee__c WHERE IDNumber__c LIKE '%s'",
				idNumber), Employee.class);

		if (result.getTotalSize() == 0) {
			response.sendRedirect("/leave-management/employeeNotFound.html");
		} else {
			Employee employee = result.getRecords().get(0);
			
			RequestDispatcher rd = request
					.getRequestDispatcher("/leave-management/viewLeave.jsp");
			request.setAttribute("employee", employee);
			rd.forward(request, response);
		}
	}

}
