package com.dao;

import java.util.List;

import com.vo.Course;


public interface CourseDAO {
	/**
	 *	显示所有信息 
	 */
	public List findAll() throws Exception;
	
	/**
	 *	新增信息 
	 */
	public boolean addNew(Course cour) throws Exception;
	
	/**
	 *	更新信息 
	 */
	public boolean update(Course cour) throws Exception;
	
	/**
	 *	删除信息 
	 */
	public boolean remove(String id) throws Exception;
}
