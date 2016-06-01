package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.messages.PageMessages;

/**
 * Servlet implementation class ErrorHandler
 */
@WebServlet("/error")
public class ErrorHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ErrorHandler() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Throwable throwable = (Throwable)
				request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
		Integer statusCode = (Integer)
				request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		System.err.println("Throwable: " + throwable);
		System.err.println("Status Code: " + statusCode);

		String errorMessage = "Error " + statusCode;

		switch(statusCode) {
		case 401:
			errorMessage += ": You are unauthorized to access this page";
			break;
		case 400:
			errorMessage += ": Bad request";
			break;
		case 403:
			errorMessage += ": Forbidden";
			break;
		case 404:
			errorMessage += ": Page not found";
			break;
		case 500:
			errorMessage += ": Internal server error";
			break;
		}

		PageMessages messages = new PageMessages();
		messages.addErrorMessage(errorMessage);
		request.setAttribute("messages", messages);

		RequestDispatcher rd = request.getRequestDispatcher("/leave-management/message.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
