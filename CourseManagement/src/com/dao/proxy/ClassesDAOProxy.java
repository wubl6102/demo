package com.dao.proxy;

import java.util.List;

import com.dao.ClassesDAO;
import com.dao.impl.ClassesDAOImpl;
import com.dbc.DatabaseConnection;
import com.vo.Classes;

public class ClassesDAOProxy implements ClassesDAO{
	private DatabaseConnection dbc = null;
	private ClassesDAOImpl dao = null;
	
	public ClassesDAOProxy() {
		try{
			this.dbc = new DatabaseConnection();
			this.dao = new ClassesDAOImpl(this.dbc.getConnection());
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
	public boolean addNew(Classes cls) throws Exception {
		try {
			return this.dao.addNew(cls);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean update(Classes cls) throws Exception {
		try {
			return this.dao.update(cls);
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
