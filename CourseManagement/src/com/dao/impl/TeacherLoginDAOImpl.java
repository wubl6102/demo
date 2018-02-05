package com.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.dao.TeacherLoginDAO;
import com.vo.Course;
import com.vo.Student;

public class TeacherLoginDAOImpl implements TeacherLoginDAO{
	private Connection conn = null;
	private PreparedStatement pstm = null;
	
	public TeacherLoginDAOImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<Course> findCourse(String id) throws Exception {
		List<Course> all = new ArrayList<Course>();
		try {
			String sql = "SELECT classes.id,course.name,classes.cour_time FROM course,classes"
						+ " WHERE classes.tea_id=? AND classes.cour_id=course.id";
			pstm = this.conn.prepareStatement(sql);
			pstm.setString(1, id);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Course cour = new Course();
				cour.setClass_id(rs.getString("classes.id"));
				cour.setName(rs.getString("course.name"));
				cour.setCour_time(rs.getString("classes.cour_time"));
				all.add(cour);
			}

		}catch(Exception e) {
			throw e;
		}finally {
			if(pstm != null) {
				try {
					this.pstm.close();
				}catch(Exception e) {
					throw e;
				}
			}
		}
		
		return all;
	}
	
	@Override
	public List<Student> findStudent(String class_id,String accept) throws Exception {
		String sql = "SELECT student.id,student.name,student.department,student.sex,student.mark,"+
				"student.tel,student.email FROM enrol,student"
				+ " WHERE enrol.class_id=? AND enrol.accept=? AND enrol.stu_id = student.id";
		List<Student> all = new ArrayList<Student>();
		try {
			pstm = this.conn.prepareStatement(sql);
			pstm.setString(1, class_id);
			pstm.setString(2, accept);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getString("student.id"));
				stu.setName(rs.getString("student.name"));
				stu.setDepartment(rs.getString("student.department"));
				stu.setSex(rs.getString("student.sex"));
				stu.setMark(rs.getString("student.mark"));
				stu.setTel(rs.getString("student.tel"));
				stu.setEmail(rs.getString("student.email"));
				all.add(stu);
			}

		}catch(Exception e) {
			throw e;
		}finally {
			if(pstm != null) {
				try {
					this.pstm.close();
				}catch(Exception e) {
					throw e;
				}
			}
		}
		
		return all;
	}
	
	@Override
	public boolean doEnrol(String class_id,String stu_id) throws Exception {
		boolean flag = false;
		try {
			String sql = "UPDATE enrol set accept=1 WHERE class_id=? AND stu_id=?";
			pstm = this.conn.prepareStatement(sql);
			pstm.setString(1, class_id);
			pstm.setString(2, stu_id);
			if(pstm.executeUpdate() > 0) {
				flag = true;
			}
		}catch(Exception e) {
			throw e;
		}finally {
			if(pstm != null) {
				try {
					this.pstm.close();
				}catch(Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}

	@Override
	public boolean doMark(String class_id, String stu_id, String score) throws Exception {
		boolean flag = false;
		try {
			String sql = "UPDATE enrol SET score=? WHERE class_id=? AND stu_id=?";
			pstm = this.conn.prepareStatement(sql);
			pstm.setString(1, score);
			pstm.setString(2, class_id);
			pstm.setString(3, stu_id);
			if(pstm.executeUpdate() > 0) {
				flag = true;
				if(Integer.parseInt(score) >= 60) {
					flag = addMark(class_id,stu_id);
				}
			}
		}catch(Exception e) {
			throw e;
		}finally {
			if(pstm != null) {
				try {
					this.pstm.close();
				}catch(Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}
	
	private boolean addMark(String class_id, String stu_id)throws Exception {
		boolean flag = false;
		int mark;
		try {
			String sql = "SELECT course.mark FROM classes,course WHERE classes.id=? "
					+ "AND classes.cour_id=course.id";
			pstm = this.conn.prepareStatement(sql);
			pstm.setString(1,class_id);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				mark = rs.getInt("mark");
				flag = doUpdateStu(stu_id,mark);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			if(pstm != null) {
				try {
					this.pstm.close();
				}catch(Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}
	
	private boolean doUpdateStu(String stu_id,int mark) throws Exception{
		boolean flag = false;
		try {
			String sql = "UPDATE student set student.mark=student.mark+? WHERE id=?";
			pstm = this.conn.prepareStatement(sql);
			pstm.setInt(1,mark);
			pstm.setString(2, stu_id);
			
			if(pstm.executeLargeUpdate() > 0) {
				flag = true;
			}
		}catch(Exception e) {
			throw e;
		}finally {
			if(pstm != null) {
				try {
					this.pstm.close();
				}catch(Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}
}



