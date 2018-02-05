package com.dao;

public interface IUserDAO {
	/**
	 *	用户登录验证
	 *	@param king 用户类型 
	 *	@param id 用户账号
	 *	@param password 密码
	 *	@return 验证的操作结果
	 *	@throws Exception
	 */
	public boolean findLogin(String kind,String id,String password) throws Exception;
}
