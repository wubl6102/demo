package com.dao;

import java.util.List;

public interface AdminDAO {
	/**
	 *	显示所有学生 
	 */
	public List findAllStudent() throws Exception;
	
	/**
	 *	显示所有老师
	 */
	public List findAllTeacher() throws Exception;
	
	/**
	 *	显示所有课程
	 */
	public List findAllCourse() throws Exception;
	
	/**
	 *	显示所有班级
	 */
	public List findAllClass() throws Exception;
}
