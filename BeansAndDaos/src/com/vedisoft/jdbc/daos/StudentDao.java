package com.vedisoft.jdbc.daos;

import com.vedisoft.jdbc.utilities.ConnectionPool;
import com.vedisoft.jdbc.utilities.DateUtils;
import com.vedisoft.jdbc.pojos.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class StudentDao {

	public void create(Student student) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into students (studentName, courseid, regDate) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, student.getStudentName());
			ps.setInt(2, student.getCourseId());
			java.sql.Date dt = new java.sql.Date(student.getRegDate().getTime());
			ps.setDate(3, dt);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Student student) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update students set studentName = ? , courseid = ? , regDate = ? where studentId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, student.getStudentName());
			ps.setInt(2, student.getCourseId());
			java.sql.Date dt = new java.sql.Date(student.getRegDate().getTime());
			ps.setDate(3, dt);
			ps.setInt(4, student.getStudentId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int studentId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from students where studentId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, studentId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Student find(int studentId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Student student = new Student();
		try {
			String sql = "select * from students where studentid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, studentId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				student.setStudentId(studentId);
				student.setStudentName(rs.getString("studentname"));
				student.setCourseId(rs.getInt("courseid"));
				java.sql.Date dt = rs.getDate("regdate");
				student.setRegDate(new java.util.Date(dt.getTime()));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return student;
	}

	public ArrayList<Student> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Student> listStudents = new ArrayList<Student>();
		try {
			String sql = "select * from students";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt("studentid"));
				student.setStudentName(rs.getString("studentname"));
				student.setCourseId(rs.getInt("courseid"));
				java.sql.Date dt = rs.getDate("regdate");
				student.setRegDate(new java.util.Date(dt.getTime()));
				listStudents.add(student);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listStudents;
	}

	public ArrayList<Student> findAllByName(String name) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Student> listStudents = new ArrayList<Student>();
		try {
			String sql = "select * from students where studentname like ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt("studentid"));
				student.setStudentName(rs.getString("studentname"));
				student.setCourseId(rs.getInt("courseid"));
				java.sql.Date dt = rs.getDate("regdate");
				student.setRegDate(new java.util.Date(dt.getTime()));
				listStudents.add(student);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listStudents;
	}

	public ArrayList<Student> findAllByCourse(int courseId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Student> listStudents = new ArrayList<Student>();
		try {
			String sql = "select * from students where courseid = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, courseId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt("studentid"));
				student.setStudentName(rs.getString("studentname"));
				student.setCourseId(rs.getInt("courseid"));
				java.sql.Date dt = rs.getDate("regdate");
				student.setRegDate(new java.util.Date(dt.getTime()));
				listStudents.add(student);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listStudents;
	}

	public static void main(String args[]) {
//		java.util.Date dt = DateUtils.convertDate("10-1-1999 10:10:15");
//		Student student = new Student("Manish Jain", 1, dt);
//		StudentDao studentDao = new StudentDao();
//		studentDao.create(student);

		// Student student = new Student(7,"Akash Jain", 1, dt);
		// StudentDao studentDao = new StudentDao();
		// studentDao.edit(student);

		// StudentDao studentDao = new StudentDao();
		// studentDao.remove(7);

		// StudentDao studentDao = new StudentDao();
		// Student student = studentDao.find(2);
		// System.out.println(student);

		// StudentDao studentDao = new StudentDao();
		// ArrayList<Student> al = studentDao.findAll();
		// for (Student student : al)
		// System.out.println(student);

		// StudentDao studentDao = new StudentDao();
		// ArrayList<Student> al = studentDao.findAllByCourse(1);
		// for (Student student : al)
		// System.out.println(student);

		// StudentDao studentDao = new StudentDao();
		// ArrayList<Student> al = studentDao.findAllByName("S");
		// for (Student student : al)
		// System.out.println(student);
	}

}
