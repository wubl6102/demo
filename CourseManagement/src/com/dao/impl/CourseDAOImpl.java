package com.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dao.CourseDAO;
import com.vo.Course;

public class CourseDAOImpl implements CourseDAO{
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	private List list = null;

	public CourseDAOImpl(Connection conn){
		this.conn = conn;
		list = new ArrayList();
	}
	
	@Override
	public List findAll() throws Exception {
		try {
			String sql = "SELECT id,name,mark,prepare,dep FROM course";
			pstm = this.conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Course cour = new Course();
				cour.setCour_id(rs.getString("id"));
				cour.setName(rs.getString("name"));
				cour.setMark(rs.getString("mark"));
				cour.setPrepare(rs.getString("prepare"));
				cour.setDep(rs.getString("dep"));
				list.add(cour);
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
	public boolean addNew(Course cour) throws Exception {
		boolean flag = false;
		try {
			String sql = "INSERT INTO course(id,name,mark,prepare,dep) VALUES(?,?,?,?,?)";
			pstm = this.conn.prepareStatement(sql);
			pstm.setString(1, cour.getCour_id());
			pstm.setString(2, cour.getName());
			pstm.setString(3, cour.getMark());
			pstm.setString(4, cour.getPrepare());
			pstm.setString(5, cour.getDep());
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
	public boolean update(Course cour) throws Exception {
		boolean flag = false;
		try {
			String sql = "UPDATE course SET name=?,mark=?,prepare=?,dep=? WHERE id=?";
			pstm = this.conn.prepareStatement(sql);
			pstm.setString(1, cour.getName());
			pstm.setString(2,cour.getMark());
			pstm.setString(3, cour.getPrepare());
			pstm.setString(4, cour.getDep());
			pstm.setString(5, cour.getCour_id());
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
			String sql = "DELETE FROM course WHERE id=?";
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
