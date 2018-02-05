package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.factory.DAOFactory;
import com.vo.Student;

public class StudentSvlt extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException,IOException{
		req.setCharacterEncoding("utf-8");
		String action = (String)req.getParameter("action");
		List all = null; 
		
		// 显示数据
		if("display".equals(action)) {
			try {
				all = DAOFactory.getStudentDAOInstance().findAll();
				req.setAttribute("list", all);
				req.getRequestDispatcher("/jsp/admin/getStudent.jsp").forward(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 新建
		if("new".equals(action)) {
			try {
				Student stu = new Student();
				stu.setId(req.getParameter("stu_id"));				
				stu.setName(req.getParameter("stu_name"));
				stu.setPassword(req.getParameter("stu_psw"));
				stu.setNativeplace(req.getParameter("stu_native"));
				stu.setSex(req.getParameter("stu_sex"));
				stu.setDepartment(req.getParameter("stu_dep"));
				
				if(DAOFactory.getStudentDAOInstance().addNew(stu)) {						
					req.getRequestDispatcher("/StudentSvlt?action=display").forward(req, res);
				}else {
					doError(req,res,"新增学生失败");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 修改
		if("update".equals(action)) {
			try {
				Student stu = new Student();
				stu.setId(req.getParameter("stu_id"));				
				stu.setName(req.getParameter("stu_name"));
				stu.setPassword(req.getParameter("stu_psw"));
				stu.setNativeplace(req.getParameter("stu_native"));
				stu.setSex(req.getParameter("stu_sex"));
				stu.setDepartment(req.getParameter("stu_dep"));
				
				if(DAOFactory.getStudentDAOInstance().update(stu)) {						
					req.getRequestDispatcher("/StudentSvlt?action=display").forward(req, res);
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
				String id = (String)req.getParameter("stu_id");
				if(DAOFactory.getStudentDAOInstance().remove(id)) {						
					req.getRequestDispatcher("/StudentSvlt?action=display").forward(req, res);
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
