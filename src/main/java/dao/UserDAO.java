package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
import utils.ConnectionDatabase;

public class UserDAO {

	public static List<User> getAll() {

		List<User> userList = new ArrayList<>();
		String query = "SELECT id, first_name, last_name, email, password, status, image, gender, role FROM users";

		try (Connection conn = ConnectionDatabase.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
	            User user = new User();
	            user.setId(rs.getLong("id"));
	            user.setFirstName(rs.getString("first_name"));
	            user.setLastName(rs.getString("last_name"));
	            user.setEmail(rs.getString("email"));
	            user.setPassword(rs.getString("password"));
	            user.setStatus(rs.getString("status"));
	            user.setImage(rs.getString("image"));
	            user.setGender(rs.getBoolean("gender"));
	            user.setRole(rs.getString("role"));
	            userList.add(user);
	        }
			 rs.close();
		        stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;

	}

	public User getUserByEmail(String email) throws SQLException, ClassNotFoundException {

		String query = "SELECT * FROM users WHERE email = ?";

		try (Connection conn = ConnectionDatabase.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Long id = rs.getLong("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String password = rs.getString("password");
				Long courseId = rs.getLong("course_id");
				Boolean gender = rs.getBoolean("gender");
				String role = rs.getString("role");
				return new User.UserBuilder()
						.withId(id)
						.withFirstName(firstName)
						.withLastName(lastName)
						.withEmail(email)
						.withPassword(password)
						.withCourseId(courseId)
						.withGender(gender)
						.withRole(role)
						.build();
			}

		}
		return null;
	}

	public static User createUser(String firstName, String lastName, String email, String password, Boolean gender,
			String status, String image) throws SQLException, ClassNotFoundException {

		String query = "INSERT INTO users (first_name, last_name, email, password,status,gender, image) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = ConnectionDatabase.getConnection();
				PreparedStatement statement = conn.prepareStatement(query)) {

			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, email);
			statement.setString(4, password);
			statement.setBoolean(5, gender);
			statement.setString(6, status);
			statement.setString(7, image);

			int rowInserted = statement.executeUpdate();

			if (rowInserted > 0) {
				try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						Long id = generatedKeys.getLong(1);
						return new User.UserBuilder()
								.withId(id)
								.withFirstName(firstName)
								.withLastName(lastName)
								.withEmail(email)
								.withPassword(password)
								.withGender(gender)
								.withStatus(status)
								.withImage(image)
								.build();
					}
				}
			}
		}
		return null;
	}

}
