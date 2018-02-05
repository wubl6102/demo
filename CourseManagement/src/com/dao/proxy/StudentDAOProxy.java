package com.dao.proxy;

import java.util.List;

import com.dao.StudentDAO;
import com.dao.impl.StudentDAOImpl;
import com.dbc.DatabaseConnection;
import com.vo.Student;

public class StudentDAOProxy implements StudentDAO{
	private DatabaseConnection conn = null;
	private StudentDAOImpl dao = null;
	
	public StudentDAOProxy() {
		try {
			this.conn = new DatabaseConnection();
			this.dao = new StudentDAOImpl(this.conn.getConnection());
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
	public boolean addNew(Student stu) throws Exception {
		try {
			return this.dao.addNew(stu);
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
	public boolean update(Student stu) throws Exception {
		try {
			return this.dao.update(stu);
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			this.conn.close();
		}
		return false;
	}

}
