package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.factory.DAOFactory;
import com.vo.Course;
import com.vo.Student;

public class TeacherLoginSvlt extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException,IOException{
		List<Student> stu_list = null;
		String action = req.getParameter("action");
		String id = req.getParameter("id");
		String class_id = (String)req.getParameter("class_id");
		
		// 挑选学生
		if("choosestu".equalsIgnoreCase(action)) {
			try {
				List<Course> cour_list = DAOFactory.getTeacherDAOLoginInstance().findCourse(id);
				req.setAttribute("course", cour_list);
				RequestDispatcher rd = req.getRequestDispatcher("/jsp/teacher/choosestu.jsp");
				rd.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			} 			
		}
		
		// 选择学生
		if("accept".equalsIgnoreCase(action)) {
			
			try {
				stu_list = DAOFactory.getTeacherDAOLoginInstance().findStudent(class_id,"0");
				req.setAttribute("student", stu_list);
				req.setAttribute("class_id", class_id);
				RequestDispatcher rd = req.getRequestDispatcher("/jsp/teacher/displaystu.jsp");
				rd.forward(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 接受学生
		if("enrol".equalsIgnoreCase(action)) {
			try {
				String stu_id = req.getParameter("stu_id");
				if(DAOFactory.getTeacherDAOLoginInstance().doEnrol(class_id,stu_id)) {
					stu_list = DAOFactory.getTeacherDAOLoginInstance().findStudent(class_id,"0");
					req.setAttribute("student", stu_list);
					req.setAttribute("class_id", class_id);
					RequestDispatcher rd = req.getRequestDispatcher("/jsp/teacher/displaystu.jsp");
					rd.forward(req, res);
				}else {
					doError(req,res,"接受失败");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 公布成绩
		if("publish".equalsIgnoreCase(action)) {
			List<Course> cour_list;
			try {
				cour_list = DAOFactory.getTeacherDAOLoginInstance().findCourse(id);
				req.setAttribute("course", cour_list);
				RequestDispatcher rd = req.getRequestDispatcher("/jsp/teacher/publish.jsp");
				rd.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		// 显示该课程学生
		if("score".equalsIgnoreCase(action)) {
			try {
				String cour_name = req.getParameter("cour_name");
				String cour_time = req.getParameter("cour_time");
				stu_list = DAOFactory.getTeacherDAOLoginInstance().findStudent(class_id,"1");
				req.setAttribute("student", stu_list);
				req.setAttribute("class_id", class_id);
				req.setAttribute("cour_name", cour_name);
				req.setAttribute("cour_time", cour_time);
				RequestDispatcher rd = req.getRequestDispatcher("/jsp/teacher/score.jsp");
				rd.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 为学生打分
		if("marking".equalsIgnoreCase(action)) {
			try {
				String stu_id = (String)req.getParameter("stu_id");
				String score = (String)req.getParameter("score");
				
				if(DAOFactory.getTeacherDAOLoginInstance().doMark(class_id,stu_id,score)) {
					stu_list = DAOFactory.getTeacherDAOLoginInstance().findStudent(class_id,"1");
					req.setAttribute("student", stu_list);
					req.setAttribute("class_id", class_id);
					RequestDispatcher rd = req.getRequestDispatcher("/jsp/teacher/score.jsp");
					rd.forward(req, res);
				}else {
					doError(req,res,"更新失败");
				}
			}catch(Exception e) {
				e.printStackTrace();
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













