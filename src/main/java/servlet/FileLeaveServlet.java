package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.SalesforceDAO;
import model.LeaveRequest;

@WebServlet(name = "fileLeaveServlet", urlPatterns = {"/leave-management/fileLeave/*","/leave-management/fileLeave" })
public class FileLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final DateFormat DF = new SimpleDateFormat("yyyy-MM-dd");

	public void init() throws ServletException {
		DF.setTimeZone(TimeZone.getTimeZone("GMT+8"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SalesforceDAO connector = new SalesforceDAO();
		
		connector.connect();
		
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
		
		String requestID = connector.create("LeaveRequest__c", leaveRequest);
		
		if(requestID != null){
			response.sendRedirect("/leave-management/getLeaveCredits?idNumber="+idNumber);
		}else{
			response.sendRedirect("/leave-management/error.html");
		}
		
	}

}
