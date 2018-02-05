package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.factory.DAOFactory;
import com.vo.Classes;
import com.vo.Course;

public class ClassesSvlt extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException,IOException{
		req.setCharacterEncoding("utf-8");
		String action = (String)req.getParameter("action");
		List all = null; 
		
		// 显示数据
		if("display".equals(action)) {
			try {
				all = DAOFactory.getClassesDAOInstance().findAll();
				req.setAttribute("list", all);
				req.getRequestDispatcher("/jsp/admin/getClasses.jsp").forward(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 新建
		if("new".equals(action)) {
			try {
				Classes cls = new Classes();
				cls.setId(req.getParameter("cls_id"));
				cls.setCour_id(req.getParameter("cour_id"));
				cls.setTea_id(req.getParameter("tea_id"));
				cls.setRoom_id(req.getParameter("room_id"));
				cls.setCour_time(req.getParameter("cour_time"));
				
				if(DAOFactory.getClassesDAOInstance().addNew(cls)) {						
					req.getRequestDispatcher("/ClassesSvlt?action=display").forward(req, res);
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
				Classes cls = new Classes();
				cls.setId(req.getParameter("cls_id"));
				cls.setCour_id(req.getParameter("cour_id"));
				cls.setTea_id(req.getParameter("tea_id"));
				cls.setRoom_id(req.getParameter("room_id"));
				cls.setCour_time(req.getParameter("cour_time"));
			
				if(DAOFactory.getClassesDAOInstance().update(cls)) {						
					req.getRequestDispatcher("/ClassesSvlt?action=display").forward(req, res);
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
				String id = (String)req.getParameter("cls_id");
				
				if(DAOFactory.getClassesDAOInstance().remove(id)) {						
					req.getRequestDispatcher("/ClassesSvlt?action=display").forward(req, res);
				}else {
					doError(req,res,"删除失败");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 获取教师、课程列表
		if("optionAdd".equals(action) || "optionUpdate".equals(action)) {
			try {
				List tealist = DAOFactory.getTeacherDAOInstance().findAll();
				List courlist = DAOFactory.getCourseDAOInstance().findAll();
				String id = (String)req.getParameter("cls_id");
				
				req.setAttribute("tealist", tealist);
				req.setAttribute("courlist", courlist);
				req.setAttribute("clsid", id);
				if("optionAdd".equals(action)) {
					req.getRequestDispatcher("/jsp/admin/addClasses.jsp").forward(req, res);
				}
				if("optionUpdate".equals(action)) {
					req.getRequestDispatcher("/jsp/admin/updateClasses.jsp").forward(req, res);
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
