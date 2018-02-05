package com.dao.impl;

import com.dao.IUserDAO;
import java.sql.*;

public class UserDAOImpl implements IUserDAO{
	private Connection conn = null;
	private PreparedStatement pstm = null;
	
	public UserDAOImpl(Connection conn) {
		this.conn = conn;
	}
	
	public boolean findLogin(String kind,String id,String password) throws Exception{
		boolean flag = false;
		try {
			String sql = "SELECT name FROM "+ kind +" WHERE id=? AND password=?";
			pstm = this.conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
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
}
