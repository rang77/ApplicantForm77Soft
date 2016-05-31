package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForgotPasswordConfirmationServlet
 */
@WebServlet("/leave-management/forgot-password-confirmation")
public class ForgotPasswordConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordConfirmationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		if(id != null && !id.isEmpty()){
			request.setAttribute("id", id);
			request.setAttribute("type", "forgot-password");
			request.getRequestDispatcher("/leave-management/confirmActivationCode.jsp").forward(request, response);
			return;
		}
		
		response.sendRedirect("/login.jsp");
	}

}
