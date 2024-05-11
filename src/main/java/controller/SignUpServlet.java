package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.UserDAO;
import model.User;
import utils.ConnectionDatabase;

@WebServlet(urlPatterns = "/register")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
   
    public SignUpServlet() {
        super();

    }
    

	@Override
	public void init(ServletConfig config) throws ServletException {
		userDAO = new UserDAO();
		
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String status = request.getParameter("status");

        // Convert image file to Base64 string
        Part filePart = request.getPart("image");
        InputStream fileContent = filePart.getInputStream();
        byte[] buffer = new byte[fileContent.available()];
        fileContent.read(buffer);
        String base64Image = Base64.getEncoder().encodeToString(buffer);

        try {
           

        	 User newUser = UserDAO.createUser(firstName, lastName, email, password, gender, status, base64Image);
        	  if (newUser != null) {
                // Registration successful
                request.setAttribute("success", "Registration successful!");
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
               
            } else {
                // Registration failed
                request.setAttribute("error", "Registration failed. Please try again.");
                request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
            }

            // Close resources
            
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred while registering: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("error", "JDBC driver not found: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
        }
    }

}
