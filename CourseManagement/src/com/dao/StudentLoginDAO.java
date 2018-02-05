package com.dao;

import java.util.List;

import com.vo.Course;
import com.vo.Enrol;
import com.vo.Score;
import com.vo.Student;

public interface StudentLoginDAO {
	/**
	 *	更新个人信息 
	 */
	public boolean doUpdate(Student stu) throws Exception;
	
	/**
	 *	查看学分 
	 */
	public List<Score> getScore(String id) throws Exception;
	
	/**
	 *	显示课程 
	 */
	public List<Course> displayCourse(String stu_id) throws Exception;
	
	/**
	 *	选修课程 
	 */
	public int doEnrol(Enrol enrol) throws Exception;
}
