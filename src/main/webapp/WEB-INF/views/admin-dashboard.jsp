
<%@page import="dao.CourseDAO"%>
<%@page import="model.Course"%>
<%@page import="dao.UserDAO"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FGPA Calculator - Admin Dashboard</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
</head>


<%
List<User> users = UserDAO.getAll();
List<Course> courses = CourseDAO.getAllCourses();
%>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 bg-light vh-80">
				<ul class="nav flex-column mt-4">
					<li class="nav-item"><a class="nav-link active" href="#"
						data-toggle="tab" data-target="#students">Students</a></li>
					<li class="nav-item"><a class="nav-link" href="#"
						data-toggle="tab" data-target="#courses">Courses</a></li>
				</ul>
			</div>
			<div class="col-md-10">
				<div class="tab-content">
					<div class="tab-pane fade show active" id="students">
						<h2>Users</h2>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>ID</th>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Email</th>
									<th>Password</th>
									<th>Status</th>
									<th>Image</th>
									<th>Gender</th>
									<th>Role</th>
								</tr>
								<%
								for (User user : users) {
								%>
								<tr>
									<td><%=user.getId()%></td>
									<td><%=user.getFirstName()%></td>
									<td><%=user.getLastName()%></td>
									<td><%=user.getEmail()%></td>
									<td><%=user.getPassword()%></td>
									<td><%=user.getStatus()%></td>
									<td><%=user.getImage()%></td>
									<td><%=user.isGender()%></td>
									<td><%=user.getRole()%></td>
								</tr>
								<%
								}
								%>
							</thead>
							<tbody>
								<!-- Here you can dynamically populate the table rows with student data from your database -->
							</tbody>
						</table>
					</div>
					<div class="tab-pane fade" id="courses">
						<h2>Courses</h2>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>ID</th>
									<th>Name</th>
									<th>Description</th>							
									<th>Total Credits</th>
									<th>Graduate</th>
								</tr>
								<%
								for (Course course : courses) {
								%>
								<tr>
									<td><%=course.getId()%></td>
									<td><%=course.getName()%></td>
									<td><%=course.getDescription()%></td>
									<td><%=course.getTotalCredits()%></td>
									<td><%=course.getDateGraduate()%></td>
									
								</tr>
								<%
								}
								%>
							</thead>
							<tbody>
								<!-- Here you can dynamically populate the table rows with course data from your database -->
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		$(document).ready(function() {
			$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
				localStorage.setItem('lastTab', $(this).attr('data-target'));
			});

			var lastTab = localStorage.getItem('lastTab');
			if (lastTab) {
				$('a[data-target="' + lastTab + '"]').tab('show');
			}
		});
	</script>
</body>
</html>