package com.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.dao.AdminDAO;
import com.vo.Classes;
import com.vo.Course;
import com.vo.Student;
import com.vo.Teacher;

public class AdminDAOImpl implements AdminDAO{
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private List list = null;
	private ResultSet rs = null;
	
	public AdminDAOImpl(Connection conn) throws Exception{
		this.conn = conn;
		this.list = new ArrayList();
	}
	
	@Override
	public List findAllStudent() throws Exception {
		try {
			String sql = "SELECT id,password,name,nativeplace,department,sex,mark,tel,email "
						+ "FROM student";
			pstm = this.conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getString("id"));
				stu.setPassword(rs.getString("password"));
				stu.setName(rs.getString("name"));
				stu.setNativeplace(rs.getString("nativeplace"));
				stu.setDepartment(rs.getString("department"));
				stu.setSex(rs.getString("sex"));
				stu.setMark(rs.getString("mark"));
				stu.setTel(rs.getString("tel"));
				stu.setEmail(rs.getString("email"));
				list.add(stu);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			if(pstm != null) {
				try {
					pstm.close();
				}catch(Exception e) {
					throw e;
				}
			}
		}
		System.out.println(list.size());
		return list;
	}

	@Override
	public List findAllTeacher() throws Exception {
		try {
			String sql = "SELECT id,name,title,password FROM teacher";
			pstm = this.conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Teacher tea = new Teacher();
				tea.setId(rs.getString("id"));
				tea.setName(rs.getString("name"));
				tea.setTitle(rs.getString("title"));
				tea.setPassword(rs.getString("password"));
				list.add(tea);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			if(pstm != null) {
				try {
					pstm.close();
				}catch(Exception e) {
					throw e;
				}
			}
		}
		return list;
	}

	@Override
	public List findAllCourse() throws Exception {
		try {
			String sql = "SELECT id,name,mark,prepare,dep FROM course";
			pstm = this.conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Course course = new Course();
				course.setCour_id(rs.getString("id"));
				course.setName(rs.getString("name"));
				course.setMark(rs.getString("mark"));
				course.setPrepare(rs.getString("prepare"));
				course.setDep(rs.getString("dep"));
				list.add(course);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			if(pstm != null) {
				try {
					pstm.close();
				}catch(Exception e) {
					throw e;
				}
			}
		}
		return list;
	}

	@Override
	public List findAllClass() throws Exception {
		try {
			String sql = "SELECT classes.id,classes.tea_id,classes.cour_id,classes.room_id,classes.cour_time,"
					+ "teacher.name,course.name"
					+ " FROM classes,teacher,course WHERE classes.tea_id=teacher.id "
					+ "AND classes.cour_id=course.id";
			pstm = this.conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Classes classes = new Classes();
				classes.setId(rs.getString("id"));
				classes.setTea_id(rs.getString("tea_id"));
				classes.setCour_id(rs.getString("cour_id"));
				classes.setRoom_id(rs.getString("room_id"));
				classes.setCour_time(rs.getString("cour_time"));
				classes.setTea_name(rs.getString("teacher.name"));
				classes.setCour_name(rs.getString("course.name"));
				list.add(classes);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			if(pstm != null) {
				try {
					pstm.close();
				}catch(Exception e) {
					throw e;
				}
			}
		}
		return list;
	}
}
