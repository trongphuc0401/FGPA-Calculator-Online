package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.User;
import utils.ConnectionDatabase;

public class CourseDAO {
	
	public static List<Course> getAllCourses() {
		List<Course> courseList = new ArrayList<>();
		String query ="SELECT * FROM courses";
		
		try (Connection conn = ConnectionDatabase.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
	            Course course = new Course();
	            course.setId(rs.getLong("id"));
	            course.setName(rs.getString("name"));
	            course.setDescription(rs.getString("description"));
	            course.setTotalCredits(rs.getInt("total_credits"));
	            course.setDateGraduate(rs.getInt("date_graduate"));
	            courseList.add(course);
	        }
			 rs.close();
		        stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseList;
	}
	
	

}
