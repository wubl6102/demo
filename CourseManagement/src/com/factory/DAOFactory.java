package com.factory;

import com.dao.AdminDAO;
import com.dao.ClassesDAO;
import com.dao.CourseDAO;
import com.dao.IUserDAO;
import com.dao.StudentDAO;
import com.dao.StudentLoginDAO;
import com.dao.TeacherDAO;
import com.dao.TeacherLoginDAO;
import com.dao.proxy.AdminDAOProxy;
import com.dao.proxy.ClassesDAOProxy;
import com.dao.proxy.CourseDAOProxy;
import com.dao.proxy.StudentDAOProxy;
import com.dao.proxy.StudentLoginDAOProxy;
import com.dao.proxy.TeacherDAOProxy;
import com.dao.proxy.TeacherLoginDAOProxy;
import com.dao.proxy.UserDAOProxy;

public class DAOFactory {
	public static IUserDAO getIUserDAOInstance() {
		return new UserDAOProxy();
	}
	
	public static StudentLoginDAO getStudentDAOLoginInstance() {
		return new StudentLoginDAOProxy();
	}
	
	public static TeacherLoginDAO getTeacherDAOLoginInstance(){
		return new TeacherLoginDAOProxy();
	}
	
	public static AdminDAO getAdminDAOInstance(){
		return new AdminDAOProxy();
	}
	
	public static StudentDAO getStudentDAOInstance() {
		return new StudentDAOProxy();
	}
	
	public static TeacherDAO getTeacherDAOInstance() {
		return new TeacherDAOProxy();
	}
	
	public static CourseDAO getCourseDAOInstance() {
		return new CourseDAOProxy();
	}
	
	public static ClassesDAO getClassesDAOInstance() {
		return new ClassesDAOProxy();
	}
}
