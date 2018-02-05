package com.dao.proxy;

import java.util.List;

import com.dao.AdminDAO;
import com.dao.impl.AdminDAOImpl;
import com.dbc.DatabaseConnection;

public class AdminDAOProxy implements AdminDAO{
	private DatabaseConnection dbc = null;
	private AdminDAOImpl dao = null;
	private List list = null;
	
	public AdminDAOProxy(){
		try {
			this.dbc = new DatabaseConnection();
			this.dao = new AdminDAOImpl(this.dbc.getConnection());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List findAllStudent() throws Exception {
		try {
			list = dao.findAllStudent();
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return list;
	}

	@Override
	public List findAllTeacher() throws Exception {
		try {
			list = dao.findAllTeacher();
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return list;
	}

	@Override
	public List findAllCourse() throws Exception {
		try {
			list = dao.findAllCourse();
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return list;
	}

	@Override
	public List findAllClass() throws Exception {
		try {
			list = dao.findAllClass();
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return list;
	}

}
