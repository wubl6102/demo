package com.dbc;

import java.sql.*;

public class DatabaseConnection {
	private final String DBDRIVER = "com.mysql.jdbc.Driver";
	private final String DBURL = "jdbc:mysql://localhost:3306/csma";
	private final String DBUSER = "root";
	private final String DBPASSWORD = "root";
	private Connection conn = null;
	
	public DatabaseConnection() throws Exception{
		try {
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public Connection getConnection() {
		return this.conn;
	}
	
	public void close() throws Exception{
		if(this.conn != null) {
			try {
				this.conn.close();
			}catch(Exception e) {
				throw e;
			}
			
		}
	}
}
