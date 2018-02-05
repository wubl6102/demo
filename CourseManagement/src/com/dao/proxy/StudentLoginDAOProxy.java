package com.dao.proxy;

import java.util.List;

import com.dao.StudentLoginDAO;
import com.dao.impl.StudentDAOLoginImpl;
import com.dao.impl.UserDAOImpl;
import com.dbc.DatabaseConnection;
import com.vo.Course;
import com.vo.Enrol;
import com.vo.Score;
import com.vo.Student;

public class StudentLoginDAOProxy implements StudentLoginDAO{
	StudentDAOLoginImpl dao = null;
	DatabaseConnection dbc = null;
	
	public StudentLoginDAOProxy(){
		try {
			this.dbc = new DatabaseConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.dao = new StudentDAOLoginImpl(this.dbc.getConnection());
	}
	
	public boolean doUpdate(Student stu)throws Exception{
		boolean flag = false;
		try {
			flag = this.dao.doUpdate(stu);
		}catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();
		}
		return flag;
	}

	public List<Score> getScore(String id) throws Exception {
		try {
			return this.dao.getScore(id);
		}catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Course> displayCourse(String stu_id) throws Exception {
		try {
			return this.dao.displayCourse(stu_id);
		}catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public int doEnrol(Enrol enrol) throws Exception {
		try {
			return this.dao.doEnrol(enrol);
		}catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();
		}
	}

}
