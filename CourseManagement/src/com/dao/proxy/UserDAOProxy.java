package com.dao.proxy;

import com.dao.IUserDAO;
import com.dao.impl.UserDAOImpl;
import com.dbc.DatabaseConnection;

public class UserDAOProxy implements IUserDAO{
	private DatabaseConnection dbc = null;
	private UserDAOImpl dao = null;
	
	public UserDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.dao = new UserDAOImpl(this.dbc.getConnection());
	}
	
	public boolean findLogin(String kind, String id, String password) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.findLogin(kind, id, password);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return flag;
	}

}
