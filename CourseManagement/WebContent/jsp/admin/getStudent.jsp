<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.vo.Student,java.net.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生更新</title>
</head>
<body>
<%
	String admin_id = (String)session.getAttribute("id");
	if(admin_id == null){
		response.sendRedirect("Login.jsp");
	}
	String path = (String)request.getContextPath();
%>
<p align="center"><font color="00FF00" size="+3" face="华文行楷">所有学生</font></p>
<p><a href="<%=path %>/jsp/admin/addStudent.jsp">
<font size="+1" face="华文行楷">增加学生</font>
</a></p>
<div align="center">
	<table width="75%" border="1">
		<tr>
			<td>学生号</td>
			<td>姓名</td>
			<td>密码</td>
			<td>籍贯</td>
			<td>系别</td>
			<td>性别</td>
			<td>学分</td>
			<td>电话</td>
			<td><p>E_mail</p></td>
			<td>删除</td>
			<td>更新</td>
		</tr>
<%
	List ls = (List)request.getAttribute("list");
	if(ls != null){
		Iterator iter = ls.iterator();
		while(iter.hasNext()){
			Student stu = (Student)iter.next();
			String id = stu.getId();
			String name = URLEncoder.encode(stu.getName(), "utf-8");
%>
		<tr>
			<td><%=id %></td>
			<td><%=stu.getName() %></td>
			<td><%=stu.getPassword() %></td>
			<td><%=stu.getNativeplace() %></td>
			<td><%=stu.getDepartment() %></td>
			<td><%=stu.getSex() %></td>
			<td><%=stu.getMark() %></td>
			<td><%=stu.getTel() %></td>
			<td><%=stu.getEmail() %></td>
			<td>
			<a href="<%=path %>/jsp/admin/updateStudent.jsp?stuid=<%=id%>&stuname=<%=name%>">更新</a>
			</td>
			<td><a href="<%=path %>/StudentSvlt?action=remove&stu_id=<%=id %>">删除</a></td>
		</tr>
<%
		}
	}
%>
	</table>
</div>
<a href="<%=path %>/jsp/admin/admin.jsp">&lt;&lt;Back</a>
</body>
</html>