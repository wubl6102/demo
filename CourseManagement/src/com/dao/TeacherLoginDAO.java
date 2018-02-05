package com.dao;

import java.util.List;

import com.vo.Course;
import com.vo.Student;

public interface TeacherLoginDAO {
	/**
	 *	获取课程信息 
	 */
	public List<Course> findCourse(String tea_id) throws Exception; 
	
	/**
	 *	获取学生信息 
	 *	@param accept 0：显示未接受学生  1：显示接受的学生
	 */
	public List<Student> findStudent(String class_id,String accept) throws Exception;
	
	
	/**
	 *	接受学生 
	 */
	public boolean doEnrol(String class_id,String stu_id) throws Exception;
	
	/**
	 *	为学生打分 
	 */
	public boolean doMark(String class_id,String stu_id,String score) throws Exception;
}



