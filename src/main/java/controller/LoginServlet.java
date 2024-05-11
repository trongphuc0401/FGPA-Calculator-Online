package controller;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UserDAO;
import model.User;


@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private UserDAO userDAO;
	
	
       
    public LoginServlet() {
        super();

    }

	public void init(ServletConfig config) throws ServletException {
		 userDAO = new UserDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        try {
        	 User user = userDAO.getUserByEmail(email);
             if (user != null && user.getPassword().equals(password)) {
                 HttpSession session = request.getSession();
                 session.setAttribute("user", user);
                 if (user.getRole().equals("admin")) {
                	 request.setAttribute("success", "Welcome Administrator");
                     response.sendRedirect("admin/admin-dashboard");
                 } else {
                	 request.setAttribute("success", "Welcome Student");
                     response.sendRedirect("student/menu");
                 }
             } else {
                 request.setAttribute("error", "Invalid email or password");
                 request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
             }
		} catch (Exception e) {
			 	e.printStackTrace();
	            request.setAttribute("error", "An error occurred while logging in");
	            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			
		}
	}

}
