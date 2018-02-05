package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.ClassesDAO;
import com.vo.Classes;
import com.vo.Course;

public class ClassesDAOImpl implements ClassesDAO{
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	private List list = null;

	public ClassesDAOImpl(Connection conn){
		this.conn = conn;
		list = new ArrayList();
	}
	
	@Override
	public List findAll() throws Exception {
		try {
			String sql = "SELECT classes.id,classes.tea_id,classes.cour_id,classes.room_id,classes.cour_time,"
						+"teacher.name,course.name FROM classes,teacher,course "
						+"WHERE classes.tea_id=teacher.id AND classes.cour_id=course.id";
			pstm = this.conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Classes cls = new Classes();
				cls.setId(rs.getString("classes.id"));
				cls.setTea_id(rs.getString("classes.tea_id"));
				cls.setCour_id(rs.getString("classes.cour_id"));
				cls.setRoom_id(rs.getString("classes.room_id"));
				cls.setCour_time(rs.getString("classes.cour_time"));
				cls.setCour_name(rs.getString("course.name"));
				cls.setTea_name(rs.getString("teacher.name"));
				list.add(cls);
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
	public boolean addNew(Classes cls) throws Exception {
		boolean flag = false;
		try {
			String sql = "INSERT INTO classes(id,tea_id,cour_id,room_id,cour_time) VALUES(?,?,?,?,?)";
			pstm = this.conn.prepareStatement(sql);
			pstm.setString(1, cls.getId());
			pstm.setString(2, cls.getTea_id());
			pstm.setString(3, cls.getCour_id());
			pstm.setString(4, cls.getRoom_id());
			pstm.setString(5, cls.getCour_time());
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
	public boolean update(Classes cls) throws Exception {
		boolean flag = false;
		try {
			String sql = "UPDATE classes SET tea_id=?,cour_id=?,room_id=?,cour_time=? WHERE id=?";
			pstm = this.conn.prepareStatement(sql);
			pstm.setString(1, cls.getTea_id());
			pstm.setString(2, cls.getCour_id());
			pstm.setString(3, cls.getRoom_id());
			pstm.setString(4, cls.getCour_time());
			pstm.setString(5, cls.getId());
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
			String sql = "DELETE FROM classes WHERE id=?";
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
