package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "courses")
@Entity
public class Course {

	private Long id;
	private String name;
	private String description;
	private Integer totalCredits;
	private Integer dateGraduate;

	public Course() {
	}

	public static class CourseBuilder {
		private Course course;

		public CourseBuilder() {
			course = new Course();
		}

		public CourseBuilder withId(Long id) {
			course.id = id;
			return this;
		}

		public CourseBuilder withName(String name) {
			course.name = name;
			return this;
		}

		public CourseBuilder withDescription(String description) {
			course.description = description;
			return this;
		}

		public CourseBuilder withTotalCredits(Integer totalCredits) {
			course.totalCredits = totalCredits;
			return this;
		}

		public CourseBuilder withDateGraduate(Integer dateGraduate) {
			course.setDateGraduate(dateGraduate);
			return this;
		}

		public Course build() {
			return course;
		}
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(Integer totalCredits) {
		this.totalCredits = totalCredits;
	}

	public Integer getDateGraduate() {
		return dateGraduate;
	}

	public void setDateGraduate(Integer dateGraduate) {
		this.dateGraduate = dateGraduate;
	}



}
