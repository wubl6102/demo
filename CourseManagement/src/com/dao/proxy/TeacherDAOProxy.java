package com.dao.proxy;

import java.util.List;

import com.dao.TeacherDAO;
import com.dao.impl.TeacherDAOImpl;
import com.dbc.DatabaseConnection;
import com.vo.Teacher;

public class TeacherDAOProxy implements TeacherDAO{
	private DatabaseConnection conn = null;
	private TeacherDAOImpl dao = null;
	
	public TeacherDAOProxy() {
		try {
			this.conn = new DatabaseConnection();
			this.dao = new TeacherDAOImpl(this.conn.getConnection());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public List findAll() throws Exception {
		try {
			return this.dao.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			this.conn.close();
		}
		return null;
	}

	@Override
	public boolean addNew(Teacher tea) throws Exception {
		try {
			return this.dao.addNew(tea);
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			this.conn.close();
		}
		return false;
	}

	@Override
	public boolean remove(String id) throws Exception {
		try {
			return this.dao.remove(id);
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			this.conn.close();
		}
		return false;
	}

	@Override
	public boolean update(Teacher tea) throws Exception {
		try {
			return this.dao.update(tea);
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			this.conn.close();
		}
		return false;
	}

}

