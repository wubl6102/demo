package com.dao.proxy;

import java.util.List;

import com.dao.CourseDAO;
import com.dao.impl.CourseDAOImpl;
import com.dbc.DatabaseConnection;
import com.vo.Course;

public class CourseDAOProxy implements CourseDAO{
	private DatabaseConnection dbc = null;
	private CourseDAOImpl dao = null;
	
	public CourseDAOProxy() {
		try{
			this.dbc = new DatabaseConnection();
			this.dao = new CourseDAOImpl(this.dbc.getConnection());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List findAll() throws Exception {
		try {
			return this.dao.findAll();
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean addNew(Course cour) throws Exception {
		try {
			return this.dao.addNew(cour);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean update(Course cour) throws Exception {
		try {
			return this.dao.update(cour);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean remove(String id) throws Exception {
		try {
			return this.dao.remove(id);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

}
