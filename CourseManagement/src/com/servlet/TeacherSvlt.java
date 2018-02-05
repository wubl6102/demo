package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.factory.DAOFactory;
import com.vo.Teacher;

public class TeacherSvlt extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException,IOException{
		req.setCharacterEncoding("utf-8");
		String action = (String)req.getParameter("action");
		List all = null; 
		
		// 显示数据
		if("display".equals(action)) {
			try {
				all = DAOFactory.getTeacherDAOInstance().findAll();
				req.setAttribute("list", all);
				req.getRequestDispatcher("/jsp/admin/getTeacher.jsp").forward(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 新建
		if("new".equals(action)) {
			try {
				Teacher tea = new Teacher();
				tea.setId(req.getParameter("tea_id"));
				tea.setName(req.getParameter("tea_name"));
				tea.setPassword(req.getParameter("tea_psw"));
				tea.setTitle(req.getParameter("tea_title"));
				if(DAOFactory.getTeacherDAOInstance().addNew(tea)) {						
					req.getRequestDispatcher("/TeacherSvlt?action=display").forward(req, res);
				}else {
					doError(req,res,"新增教师失败");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 修改
		if("update".equals(action)) {
			try {
				Teacher tea = new Teacher();
				tea.setId(req.getParameter("tea_id"));
				tea.setName(req.getParameter("tea_name"));
				tea.setPassword(req.getParameter("tea_psw"));
				tea.setTitle(req.getParameter("tea_title"));
				if(DAOFactory.getTeacherDAOInstance().update(tea)) {						
					req.getRequestDispatcher("/TeacherSvlt?action=display").forward(req, res);
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
				String id = (String)req.getParameter("tea_id");
				System.out.println(id);
				if(DAOFactory.getTeacherDAOInstance().remove(id)) {						
					req.getRequestDispatcher("/TeacherSvlt?action=display").forward(req, res);
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
