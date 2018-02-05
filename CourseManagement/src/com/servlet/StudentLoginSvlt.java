package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;

import com.factory.DAOFactory;
import com.vo.Course;
import com.vo.Enrol;
import com.vo.Score;
import com.vo.Student;

import java.io.IOException;
import java.sql.*;
import java.util.List;

/**
 *	用户模块功能的操作 Servlet，它包括更新学生的信息，查看学生的学分，选修课程 
 *
 */
public class StudentLoginSvlt extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException,IOException{
		String action = req.getParameter("action");
		String id = req.getParameter("id");
		
		// 更新学生信息
		if("update".equalsIgnoreCase(action)) {
			Student stu = new Student();
			stu.setId(id);
			
			String pw1 = req.getParameter("password1");
			String pw2 = req.getParameter("password2");
			
			if(pw1.equals("") || pw2.equals("") || pw1 == null || pw2 == null) {
				doError(req,res,"密码不能为空");
			}else if(!pw1.equals(pw2)) {
				doError(req,res,"密码不一致");
			}else {
				stu.setPassword(pw1);
				stu.setEmail(req.getParameter("email"));
				stu.setTel(req.getParameter("tel"));
				try {
					if(DAOFactory.getStudentDAOLoginInstance().doUpdate(stu)) {
						res.sendRedirect(req.getContextPath()+"/jsp/student/student.jsp");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		// 查看学生学分
		if("checkmark".equalsIgnoreCase(action)) {
			try{
				List<Score> all = DAOFactory.getStudentDAOLoginInstance().getScore(id);
				req.setAttribute("score", all);
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/jsp/student/checkmark.jsp");
				rd.forward(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 显示课程
		if("display".equalsIgnoreCase(action)) {
			try{
				List<Course> all = DAOFactory.getStudentDAOLoginInstance().displayCourse(id);
				req.setAttribute("course", all);
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/jsp/student/DisplayCourse.jsp");
				rd.forward(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//选修课程
		if("enrol".equalsIgnoreCase(action)){
			int num = 0;
			Enrol enrol = new Enrol();
			enrol.setStu_id((String)req.getAttribute("id"));
			enrol.setClass_id((String)req.getAttribute("class_id"));
			if("0".equals((String)req.getAttribute("prepare"))){
				try {
					num = DAOFactory.getStudentDAOLoginInstance().doEnrol(enrol);				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if(num == 0) {
				doError(req,res,"注册课程失败！！！");
			}
		}
	}
	
	
	/**
	 * 显示出错明细
	 * 
	 */
	public void doError(HttpServletRequest req,HttpServletResponse res,String str)
			throws ServletException,IOException{
		req.setAttribute("problem", str);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/errorpage.jsp");
		rd.forward(req, res);
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException,IOException{
		doGet(req,res);
	}
}



















