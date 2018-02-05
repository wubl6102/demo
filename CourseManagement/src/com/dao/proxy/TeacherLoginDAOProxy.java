package com.dao.proxy;

import java.sql.*;
import java.util.List;

import com.dao.TeacherLoginDAO;
import com.dao.impl.TeacherLoginDAOImpl;
import com.dbc.DatabaseConnection;
import com.vo.Course;
import com.vo.Student;

public class TeacherLoginDAOProxy implements TeacherLoginDAO{
	private DatabaseConnection dbc = null;
	private TeacherLoginDAOImpl dao = null;
	
	public TeacherLoginDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new TeacherLoginDAOImpl(this.dbc.getConnection());
	}
	
	@Override
	public List<Course> findCourse(String id) throws Exception {
		try {
			return this.dao.findCourse(id);
		}catch(Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public List<Student> findStudent(String class_id,String accept) throws Exception {
		try {
			return this.dao.findStudent(class_id,accept);
		}catch(Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	

	@Override
	public boolean doEnrol(String class_id,String stu_id) throws Exception {
		boolean flag = false;
		try {
			flag =  this.dao.doEnrol(class_id,stu_id);
		}catch(Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doMark(String class_id, String stu_id, String score) throws Exception {
		boolean flag = false;
		try {
			flag =  this.dao.doMark(class_id,stu_id,score);
		}catch(Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

}










