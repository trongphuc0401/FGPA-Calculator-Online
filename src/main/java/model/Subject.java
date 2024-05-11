package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "subjects")
@Entity
public class Subject {
	
	private Long id;
	
	private String name;
	
	private int credit ; 
	
	private Long courseId;
	
	public Subject() {}

	 public static class SubjectBuilder {
	        private Subject subject;

	        public SubjectBuilder() {
	            subject = new Subject();
	        }

	        public SubjectBuilder withId(Long id) {
	            subject.id = id;
	            return this;
	        }

	        public SubjectBuilder withName(String name) {
	            subject.name = name;
	            return this;
	        }

	        public SubjectBuilder withCredit(int credit) {
	            subject.credit = credit;
	            return this;
	        }

	        public SubjectBuilder withCourseId(Long courseId) {
	            subject.courseId = courseId;
	            return this;
	        }

	        public Subject build() {
	            return subject;
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

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	};

	
}
