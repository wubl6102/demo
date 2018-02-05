package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.factory.DAOFactory;
import com.vo.Student;

public class AdminLoginSvlt extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException,IOException{
		req.setCharacterEncoding("utf-8");
		String action = (String)req.getParameter("action");
		String name = (String)req.getParameter("name");
		List all = null; 
		
		// 显示数据
		if("display".equals(action)) {
			try {
				String path = "/jsp/admin/get" + name.substring(0,1).toUpperCase() + name.substring(1) + ".jsp";
				System.out.println(path);
				if("student".equalsIgnoreCase(name)) {
					all = DAOFactory.getStudentDAOInstance().findAll();
					
				}else if("teacher".equalsIgnoreCase(name)) {
					
					all = DAOFactory.getAdminDAOInstance().findAllTeacher();
					
				}else if("course".equalsIgnoreCase(name)) {
					
					all = DAOFactory.getAdminDAOInstance().findAllCourse();
					
				}else if("class".equalsIgnoreCase(name)) {
					
					all = DAOFactory.getAdminDAOInstance().findAllClass();
				}
				req.setAttribute("list", all);
				req.getRequestDispatcher(path).forward(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 新建
		if("new".equals(action)) {
			try {
				String path = "/AdminLoginSvlt?action=display&name="+name;
				System.out.println(path);
				if("student".equalsIgnoreCase(name)) {
					Student stu = new Student();
					stu.setId(req.getParameter("stu_id"));
					
					stu.setName(req.getParameter("stu_name"));
					System.out.println(stu.getId()+" " + stu.getName());
					stu.setPassword(req.getParameter("stu_psw"));
					stu.setNativeplace(req.getParameter("stu_native"));
					stu.setSex(req.getParameter("stu_sex"));
					stu.setDepartment(req.getParameter("stu_dep"));
					
					if(DAOFactory.getStudentDAOInstance().addNew(stu)) {						
						req.getRequestDispatcher(path).forward(req, res);
					}else {
						doError(req,res,"新增学生失败");
					}
					
				}else if("teacher".equalsIgnoreCase(name)) {
					
					all = DAOFactory.getAdminDAOInstance().findAllTeacher();
					
				}else if("course".equalsIgnoreCase(name)) {
					
					all = DAOFactory.getAdminDAOInstance().findAllCourse();
					
				}else if("class".equalsIgnoreCase(name)) {
					
					all = DAOFactory.getAdminDAOInstance().findAllClass();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 修改
		if("update".equals(action)) {
			
		}
		
		// 删除
		if("delete".equals(action)) {
			
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
