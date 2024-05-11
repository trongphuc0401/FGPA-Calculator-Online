package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class DashboardSevlet
 */

@WebServlet(urlPatterns="/admin/admin-dashboard")
public class DashboardSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		userDAO = new UserDAO();
	}


	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			User user  = (User) session.getAttribute("user");
			
			if (user.getRole().equals("admin")) {
				request.getRequestDispatcher("/WEB-INF/views/admin-dashboard.jsp").forward(request, response);
			} else {
				response.sendRedirect("login");
			}
			
			
		
		
	}
	
	protected void doPerform(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
