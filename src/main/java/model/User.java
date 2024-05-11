package model;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String status;
	private Long courseId;
	private String image;
	private boolean gender;
	private String role;

	public static class UserBuilder {
		private User user;

		public UserBuilder() {
			user = new User();
		}

		public UserBuilder withId(Long id) {
			user.id = id;
			return this;
		}

		public UserBuilder withFirstName(String firstName) {
			user.firstName = firstName;
			return this;
		}

		public UserBuilder withLastName(String lastName) {
			user.lastName = lastName;
			return this;
		}

		public UserBuilder withEmail(String email) {
			user.email = email;
			return this;
		}

		public UserBuilder withPassword(String password) {
			user.password = password;
			return this;
		}

		public UserBuilder withStatus(String status) {
			user.status = status;
			return this;
		}

		public UserBuilder withCourseId(Long courseId) {
			user.courseId = courseId;
			return this;
		}

		public UserBuilder withImage(String image) {
			user.image = image;
			return this;
		}

		public UserBuilder withGender(boolean gender) {
			user.gender = gender;
			return this;
		}

		public UserBuilder withRole(String role) {
			user.role = role;
			return this;
		}

		public User build() {
			return user;
		}
	}

	public User(Long id, String firstName, String lastName, String email, String password, String status, Long courseId,
			String image, boolean gender, String role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.status = status;
		this.courseId = courseId;
		this.image = image;
		this.gender = gender;
		this.role = role;
	}

	public User() {

	}

	public User(Long id, String firstName, String lastName, String email, String password, String status, String image,
			boolean gender, String role) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.status = status;
		this.image = image;
		this.gender = gender;
		this.role = role;
	}

	public User(Long id2, String firstName2, String lastName2, String email2, String password2, boolean gender2,
			String status2, String image2) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", status=" + status + ", courseId=" + courseId + ", image=" + image
				+ ", gender=" + gender + ", role=" + role + "]";
	}

}
