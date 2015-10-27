package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.force.api.ApiConfig;
import com.force.api.ForceApi;

import model.LeaveRequest;

@WebServlet(name = "fileLeaveServlet", urlPatterns = {
		"/leave-management/fileLeave/*",
		"/leave-management/fileLeave" }, initParams = {
				// clientId is 'Consumer Key' in the Remote Access UI
				@WebInitParam(name = "clientId", value = "3MVG9ZL0ppGP5UrC9R5pfGadp9_.sezTYM4KyOofpmNB9S0IumaT57vNAI1j0Xbl6fJInNkjvcIDSCKZ9ypMm"),
				// clientSecret is 'Consumer Secret' in the Remote Access UI
				@WebInitParam(name = "clientSecret", value = "8568904816664843552"),
				// This must be identical to 'Callback URL' in the Remote Access
				// UI
				@WebInitParam(name = "environment", value = "https://login.salesforce.com"), })
public class FileLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final DateFormat DF = new SimpleDateFormat("yyyy-MM-dd");
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
		DF.setTimeZone(TimeZone.getTimeZone("GMT+8"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApiConfig config = new ApiConfig();
		config.setUsername(USERNAME);
		config.setPassword(PASSWORD + SECURITY_TOKEN);
		config.setClientId(clientId);
		config.setClientSecret(clientSecret);
		config.setLoginEndpoint(environment);
		
		String recordId = request.getParameter("recordId");
		String idNumber = request.getParameter("idNumber");
		String leaveType = request.getParameter("leaveType");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		LeaveRequest leaveRequest = new LeaveRequest();
		
		leaveRequest.setEmployeeID(recordId);
		leaveRequest.setLeaveType(leaveType);
		
		try {
			leaveRequest.setStartDate(DF.parse(startDate));
		} catch (ParseException e) {
		}
		try {
			leaveRequest.setEndDate(DF.parse(endDate));
		} catch (ParseException e) {
		}
		
		ForceApi api = new ForceApi(config);
		
		String requestID = api.createSObject("LeaveRequest__c", leaveRequest);
		
		if(requestID != null){
			response.sendRedirect("/leave-management/getLeaveCredits?idNumber="+idNumber);
		}else{
			response.sendRedirect("/leave-management/error.html");
		}
		
	}

}
