package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.factory.DAOFactory;
import com.vo.Course;

public class CourseSvlt extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException,IOException{
		req.setCharacterEncoding("utf-8");
		String action = (String)req.getParameter("action");
		List all = null; 
		
		// 显示数据
		if("display".equals(action)) {
			try {
				all = DAOFactory.getCourseDAOInstance().findAll();
				req.setAttribute("list", all);
				req.getRequestDispatcher("/jsp/admin/getCourse.jsp").forward(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 新建
		if("new".equals(action)) {
			try {
				Course cour = new Course();
				cour.setCour_id(req.getParameter("cour_id"));
				cour.setName(req.getParameter("cour_name"));
				cour.setMark(req.getParameter("cour_mark"));
				cour.setPrepare(req.getParameter("cour_pre"));
				cour.setDep(req.getParameter("cour_dep"));
				if(DAOFactory.getCourseDAOInstance().addNew(cour)) {						
					req.getRequestDispatcher("/CourseSvlt?action=display").forward(req, res);
				}else {
					doError(req,res,"新增课程失败");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 修改
		if("update".equals(action)) {
			try {
				Course cour = new Course();
				cour.setCour_id(req.getParameter("cour_id"));
				cour.setName(req.getParameter("cour_name"));
				cour.setMark(req.getParameter("cour_mark"));
				cour.setPrepare(req.getParameter("cour_pre"));
				cour.setDep(req.getParameter("cour_dep"));
				if(DAOFactory.getCourseDAOInstance().update(cour)) {						
					req.getRequestDispatcher("/CourseSvlt?action=display").forward(req, res);
				}else {
					doError(req,res,"更新失败");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 删除
		if("remove".equals(action)) {
			try {
				String id = (String)req.getParameter("cour_id");
				
				if(DAOFactory.getCourseDAOInstance().remove(id)) {						
					req.getRequestDispatcher("/CourseSvlt?action=display").forward(req, res);
				}else {
					doError(req,res,"删除失败");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException,IOException{
		doGet(req,res);
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
}
