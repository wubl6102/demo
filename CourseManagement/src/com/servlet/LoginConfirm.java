package com.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.factory.DAOFactory;

/**
 * 判断用户认证信息
 *  
 */
public class LoginConfirm extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException,IOException {
		String message = null;
		String kind = null;
		String id = null;
		String password = null;
		
		kind = req.getParameter("kind");
		
		id = req.getParameter("id");
		HttpSession session = req.getSession(true);
		session.setAttribute("id", String.valueOf(id));
		
		password = req.getParameter("password");
		
		try {
			if(DAOFactory.getIUserDAOInstance().findLogin(kind, id, password)) {
				goo(req,res,kind);
			}else {
				message = "用户名或密码有误！";
				doError(req,res,message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 *	用户通过验证后，通过此函数来跳转到不同显示页面 
	 */
	public void goo(HttpServletRequest req,HttpServletResponse res,String kind)
			throws ServletException,IOException {
		if(kind.equals("student")) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/student/student.jsp");
			rd.forward(req, res);
		}
		
		if(kind.equals("teacher")) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/teacher/teacher.jsp");
			rd.forward(req, res);
		}
		
		if(kind.equals("admin")) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/admin/admin.jsp");
			rd.forward(req, res);
		}
	} 
	
	public void doError(HttpServletRequest req,HttpServletResponse res,String str)
			throws ServletException,IOException {
		req.setAttribute("problem", str);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/errorpage.jsp");
		rd.forward(req, res);
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException {
		String action = req.getParameter("action");
		if("logout".equalsIgnoreCase(action)) {
			HttpSession session = req.getSession(true);
			session.invalidate();
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/Login.jsp");
			rd.forward(req, res);
		}
	}
}







