package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.force.api.ApiException;

import db.LeaveRequestDAO;
import model.LeaveRequest;
import model.error.SalesforceError;

@WebServlet(name = "fileLeaveServlet", urlPatterns = {"/leave-management/fileLeave/*","/leave-management/fileLeave" })
public class FileLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final ObjectMapper MAPPER = new ObjectMapper();

	public void init() throws ServletException {
		MAPPER.enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaveRequestDAO leaveRequestDAO = new LeaveRequestDAO();
		
		String recordId = request.getParameter("recordId");
		String idNumber = request.getParameter("idNumber");
		String leaveType = request.getParameter("leaveType");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String reason = request.getParameter("leaveReason");
		
		LeaveRequest leaveRequest = new LeaveRequest();
		
		leaveRequest.setEmployeeID(recordId);
		leaveRequest.setLeaveType(leaveType);
		leaveRequest.setStartDate(startDate);
		leaveRequest.setEndDate(endDate);
		leaveRequest.setReason(reason);
		
		try{
			
			String requestID = leaveRequestDAO.createLeaveRequest(leaveRequest);
			if(requestID != null){
				response.sendRedirect("/leave-management/getLeaveCredits?idNumber="+idNumber);
			}else{
				response.sendRedirect("/leave-management/error.jsp");
			}
			
		}catch(ApiException e){
			SalesforceError error = handleAPIException(e.getMessage());
			if(error != null){
				request.setAttribute("error", error);
			}
			
			request.setAttribute("idNumber", idNumber);
			
			RequestDispatcher rd = request.getRequestDispatcher("/leave-management/error.jsp");
			rd.forward(request, response);
		}
		
	}
	
	private SalesforceError handleAPIException(String message){
		try {
			List<SalesforceError> error = MAPPER.readValue(message, new TypeReference<List<SalesforceError>>(){});
			return error.get(0);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
