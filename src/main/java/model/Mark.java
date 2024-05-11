package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "marks")
@Entity
public class Mark {

	private Long id;
	private Long userId;
	private Long subjectId;
	private Float regularMark;
	private Float middleMark;
	private Float finalMark;
	private Float totalMark;
	private String grade;

	public Mark() {
	}

	public static class MarkBuilder {
		private Mark mark;

		public MarkBuilder() {
			mark = new Mark();
		}

		public MarkBuilder withId(Long id) {
			mark.id = id;
			return this;
		}

		public MarkBuilder withUserId(Long userId) {
			mark.userId = userId;
			return this;
		}

		public MarkBuilder withSubjectId(Long subjectId) {
			mark.subjectId = subjectId;
			return this;
		}

		public MarkBuilder withRegularMark(Float regularMark) {
			mark.regularMark = regularMark;
			return this;
		}

		public MarkBuilder withMiddleMark(Float middleMark) {
			mark.middleMark = middleMark;
			return this;
		}

		public MarkBuilder withFinalMark(Float finalMark) {
			mark.finalMark = finalMark;
			return this;
		}

		public MarkBuilder withTotalMark(Float totalMark) {
			mark.totalMark = totalMark;
			return this;
		}

		public MarkBuilder withGrade(String grade) {
			mark.grade = grade;
			return this;
		}

		public Mark build() {
			return mark;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Float getRegularMark() {
		return regularMark;
	}

	public void setRegularMark(Float regularMark) {
		this.regularMark = regularMark;
	}

	public Float getMiddleMark() {
		return middleMark;
	}

	public void setMiddleMark(Float middleMark) {
		this.middleMark = middleMark;
	}

	public Float getFinalMark() {
		return finalMark;
	}

	public void setFinalMark(Float finalMark) {
		this.finalMark = finalMark;
	}

	public Float getTotalMark() {
		return totalMark;
	}

	public void setTotalMark(Float totalMark) {
		this.totalMark = totalMark;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	};

}
