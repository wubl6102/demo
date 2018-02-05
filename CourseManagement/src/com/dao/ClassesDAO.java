package com.dao;

import java.util.List;

import com.vo.Classes;

public interface ClassesDAO {
	/**
	 *	显示所有信息 
	 */
	public List findAll() throws Exception;
	
	/**
	 *	新增信息 
	 */
	public boolean addNew(Classes cls) throws Exception;
	
	/**
	 *	更新信息 
	 */
	public boolean update(Classes cls) throws Exception;
	
	/**
	 *	删除信息 
	 */
	public boolean remove(String id) throws Exception;
}
