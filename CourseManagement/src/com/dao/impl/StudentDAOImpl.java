package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.StudentDAO;
import com.vo.Student;

public class StudentDAOImpl implements StudentDAO{
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private List list = null;
	private ResultSet rs = null;
	
	public StudentDAOImpl(Connection conn) throws Exception{
		this.conn = conn;
		this.list = new ArrayList();
	}
	
	@Override
	public List findAll() throws Exception {
		try {
			String sql = "SELECT id,password,name,nativeplace,department,sex,mark,tel,email "
						+ "FROM student";
			pstm = this.conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getString("id"));
				stu.setPassword(rs.getString("password"));
				stu.setName(rs.getString("name"));
				stu.setNativeplace(rs.getString("nativeplace"));
				stu.setDepartment(rs.getString("department"));
				stu.setSex(rs.getString("sex"));
				stu.setMark(rs.getString("mark"));
				stu.setTel(rs.getString("tel"));
				stu.setEmail(rs.getString("email"));
				list.add(stu);
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
		System.out.println(list.size());
		return list;
	}

	@Override
	public boolean update(Student stu) throws Exception {
		boolean flag = false;
		try {
			String sql = "UPDATE student SET password=?,name=?,nativeplace=?,department=?,sex=? WHERE id=?";
			pstm = this.conn.prepareStatement(sql);		
			pstm.setString(1, stu.getPassword());
			pstm.setString(2, stu.getName());
			pstm.setString(3, stu.getNativeplace());
			pstm.setString(4, stu.getDepartment());
			pstm.setString(5, stu.getSex());
			pstm.setString(6, stu.getId());
			
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
	public boolean addNew(Student stu) throws Exception {
		boolean flag = false;
		try {
			String sql = "INSERT INTO student(id,password,name,nativeplace,department,sex,mark,tel,email) "
						+ "VALUES(?,?,?,?,?,?,?,?,?)";
			pstm = this.conn.prepareStatement(sql);
			pstm.setString(1, stu.getId());
			pstm.setString(2, stu.getPassword());
			pstm.setString(3, stu.getName());
			pstm.setString(4, stu.getNativeplace());
			pstm.setString(5, stu.getDepartment());
			pstm.setString(6, stu.getSex());
			pstm.setString(7, stu.getMark());
			pstm.setString(8, stu.getTel());
			pstm.setString(9, stu.getEmail());
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
		System.out.println(list.size());
		return flag;
	}

	@Override
	public boolean remove(String id) throws Exception {
		boolean flag = false;
		try {
			String sql = "DELETE FROM student WHERE id=?";
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
