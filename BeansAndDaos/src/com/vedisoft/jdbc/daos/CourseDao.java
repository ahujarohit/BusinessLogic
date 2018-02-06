package com.vedisoft.jdbc.daos;

import com.vedisoft.jdbc.utilities.ConnectionPool;
import com.vedisoft.jdbc.pojos.*;
import java.sql.*;
import java.util.*;

public class CourseDao {

	public void create(Course course) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into courses (coursename, coursetype) " + "values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, course.getCourseName());
			ps.setString(2, course.getCourseType());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Course course) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update courses " + "set coursename = ?, coursetype = ? where courseid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, course.getCourseName());
			ps.setString(2, course.getCourseType());
			ps.setInt(3, course.getCourseId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int courseId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from courses where courseid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, courseId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Course find(int courseId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Course course = new Course();
		try {
			String sql = "select * from courses where courseid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, courseId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				course.setCourseId(courseId);
				course.setCourseName(rs.getString("coursename"));
				course.setCourseType(rs.getString("coursetype"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return course;
	}

	public ArrayList<Course> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Course> listCourses = new ArrayList<Course>();
		try {
			String sql = "select * from courses";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getInt("courseId"));
				course.setCourseName(rs.getString("coursename"));
				course.setCourseType(rs.getString("coursetype"));
				listCourses.add(course);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row.");
		} finally {
			pool.putConnection(conn);
		}
		return listCourses;
	}

	public ArrayList<Course> findAllByCourseType(String courseType) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Course> listCourses = new ArrayList<Course>();
		try {
			String sql = "select * from courses where coursetype = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, courseType);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getInt("courseId"));
				course.setCourseName(rs.getString("coursename"));
				course.setCourseType(rs.getString("coursetype"));
				listCourses.add(course);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listCourses;
	}

	public static void main(String args[]) {

//		 Course course = new Course("Java","Certificate");
//		 CourseDao courseDao = new CourseDao();
//		 courseDao.create(course);

//		 Course course = new Course(9,"Big Data","Diploma");
//		 CourseDao courseDao = new CourseDao();
//		 courseDao.edit(course);

//		 CourseDao courseDao = new CourseDao();
//		 courseDao.remove(9);

//		CourseDao courseDao = new CourseDao();
//		ArrayList<Course> al = courseDao.findAll();
//		for (Course course : al) {
//			System.out.println(course);
//		}

		CourseDao courseDao = new CourseDao();
		ArrayList<Course> al = courseDao.findAllByCourseType("diploma");
		for (Course course : al) {
			System.out.println(course);
		 }

//		 CourseDao courseDao = new CourseDao();
//		 Course course = courseDao.find(1);
//		 System.out.println(course);

	}
}
