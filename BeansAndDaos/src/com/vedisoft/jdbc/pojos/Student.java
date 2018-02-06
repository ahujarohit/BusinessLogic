package com.vedisoft.jdbc.pojos;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {

	private int studentId;
	private String studentName;
	private int courseId;
	private Date regDate;

	public Student() {
		studentName = new String();
		regDate = new Date();
	}

	public Student(String studentName, int courseId, Date regDate) {
		this.studentName = studentName;
		this.courseId = courseId;
		this.regDate = regDate;
	}

	public Student(int studentId, String studentName, int courseId, Date regDate) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.courseId = courseId;
		this.regDate = regDate;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public int hashCode() {
		return studentId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Student) {
			Student s = (Student) obj;
			if (studentId == s.studentId && studentName.equals(s.studentName)
					&& courseId == s.courseId)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Student[" + studentId + "," + studentName + "," + courseId
				+ "," + regDate + "]";
	}
}
