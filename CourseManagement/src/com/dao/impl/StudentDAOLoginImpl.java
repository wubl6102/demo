package com.dao.impl;

import com.dao.StudentLoginDAO;
import com.vo.Course;
import com.vo.Enrol;
import com.vo.Score;
import com.vo.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOLoginImpl implements StudentLoginDAO{
	Connection conn = null;
	PreparedStatement pstm = null;
	
	public StudentDAOLoginImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean doUpdate(Student stu) throws Exception {
		boolean flag = false;
		try {
			String sql = "UPDATE student SET password=?,tel=?,email=? WHERE id=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, stu.getPassword());
			pstm.setString(2, stu.getTel());
			pstm.setString(3, stu.getEmail());
			pstm.setString(4, stu.getId());
			if(pstm.executeUpdate() > 0) {
				flag = true;
			}
		}catch(Exception e) {
			throw e;
		}finally {
			if(this.pstm != null) {
				try {
					this.pstm.close();
				}catch(Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}

	public List<Score> getScore(String id) throws Exception{
		List<Score> all = new ArrayList<Score>();
		try {
			String sql = "SELECT enrol.score,course.name,course.mark "
					+ "FROM enrol,course,classes " + "WHERE enrol.stu_id=? "
					+ "AND enrol.class_id=classes.id AND classes.cour_id=course.id";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Score sc = new Score();
				sc.setScore(rs.getString("score"));
				sc.setCour_name(rs.getString("name"));
				sc.setCour_mark(rs.getString("mark"));
				all.add(sc);
			}		
		}catch(Exception e) {
			throw e;
		}finally {
			if(this.pstm != null) {
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
	public List<Course> displayCourse(String stu_id) throws Exception {
		List<Course> all = new ArrayList<Course>();
		try {
			String sql = "SELECT course.id,course.name,course.prepare,course.dep,"
					+ "classes.id,classes.room_id,classes.cour_time,teacher.name "
					+ "FROM student,course,classes,teacher " + "WHERE student.id=? "
					+ "AND student.department = course.dep "
					+ "AND course.id = classes.cour_id "
					+ "AND classes.tea_id = teacher.id";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, stu_id);
			
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Course cour = new Course();
				cour.setCour_id(rs.getString(1));
				cour.setName(rs.getString(2));
				cour.setPrepare(rs.getString(3));
				cour.setDep(rs.getString(4));
				cour.setClass_id(rs.getString(5));
				cour.setRoom_id(rs.getString(6));
				cour.setCour_time(rs.getString(7));
				cour.setTea_name(rs.getString(8));
				all.add(cour);
			}		
		}catch(Exception e) {
			throw e;
		}finally {
			if(this.pstm != null) {
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
	public int doEnrol(Enrol enrol) throws Exception {
		int num = 0;
		try {
			String sql = "INSERT INTO enrol(stu_id,class_id) VALUES(?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, enrol.getStu_id());
			pstm.setString(2, enrol.getClass_id());
			num = pstm.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			if(this.pstm != null) {
				try {
					this.pstm.close();
				}catch(Exception e) {
					throw e;
				}
			}
		}
		return num;
	}
}






