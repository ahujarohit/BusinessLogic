package com.vedisoft.jdbc.pojos;

import java.io.Serializable;

public class Course implements Serializable {
	
	protected int courseId;
	protected String courseName;
	protected String courseType;

	public Course() {
		courseName = new String();
		courseType = new String();
	}

	public Course(String courseName, String courseType) {
		this.courseName = courseName;
		this.courseType = courseType;
	}

	public Course(int courseId, String courseName, String courseType) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseType = courseType;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	@Override
	public int hashCode() {
		return courseId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null || obj instanceof Course) {
			Course c = (Course) obj;
			if (courseId == c.courseId && courseName.equals(c.courseName) && courseType.equals(c.courseType))
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Course[" + courseId + "," + courseName + "," + courseType + "]";
	}
}








