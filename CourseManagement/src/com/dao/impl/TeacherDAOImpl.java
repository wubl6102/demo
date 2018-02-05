package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.TeacherDAO;
import com.vo.Teacher;

public class TeacherDAOImpl implements TeacherDAO{

	private Connection conn = null;
	private PreparedStatement pstm = null;
	private List list = null;
	private ResultSet rs = null;
	
	public TeacherDAOImpl(Connection conn) throws Exception{
		this.conn = conn;
		this.list = new ArrayList();
	}
	
	@Override
	public List findAll() throws Exception {
		try {
			String sql = "SELECT id,name,title,password FROM teacher";
			pstm = this.conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Teacher tea = new Teacher();
				tea.setId(rs.getString("id"));
				tea.setName(rs.getString("name"));
				tea.setTitle(rs.getString("title"));
				tea.setPassword(rs.getString("password"));
				list.add(tea);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			if(pstm != null) {
				try {
					pstm.close();
				}catch(Exception e) {
					throw e;
				}
			}
		}
		return list;
	}

	@Override
	public boolean addNew(Teacher tea) throws Exception {
		boolean flag = false;
		try {
			String sql = "INSERT INTO teacher(name,title,password,id) VALUES(?,?,?,?)";
			pstm = this.conn.prepareStatement(sql);		
			pstm.setString(1, tea.getName());
			pstm.setString(2, tea.getTitle());
			pstm.setString(3, tea.getPassword());
			pstm.setString(4, tea.getId());
			
			if(pstm.executeUpdate() > 0) {
				flag = true;
			}			
		}catch(Exception e) {
			throw e;
		}finally {
			if(pstm != null) {
				try {
					pstm.close();
				}catch(Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}

	@Override
	public boolean update(Teacher tea) throws Exception {
		boolean flag = false;
		try {
			String sql = "UPDATE teacher SET password=?,name=?,title=? WHERE id=?";
			pstm = this.conn.prepareStatement(sql);		
			pstm.setString(1, tea.getPassword());
			pstm.setString(2, tea.getName());
			pstm.setString(3, tea.getTitle());
			pstm.setString(4, tea.getId());
			
			if(pstm.executeUpdate() > 0) {
				flag = true;
			}			
		}catch(Exception e) {
			throw e;
		}finally {
			if(pstm != null) {
				try {
					pstm.close();
				}catch(Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}

	@Override
	public boolean remove(String id) throws Exception {
		boolean flag = false;
		try {
			String sql = "DELETE FROM teacher WHERE id=?";
			pstm = this.conn.prepareStatement(sql);
			pstm.setString(1, id);
			if(pstm.executeUpdate() > 0) {
				flag = true;
			}			
		}catch(Exception e) {
			throw e;
		}finally {
			if(pstm != null) {
				try {
					pstm.close();
				}catch(Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}
}
