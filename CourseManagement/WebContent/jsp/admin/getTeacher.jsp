<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.vo.Teacher,java.net.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师更新</title>
</head>
<body>
<%
	String admin_id = (String)session.getAttribute("id");
	if(admin_id == null){
		response.sendRedirect("Login.jsp");
	}
	String path = (String)request.getContextPath();
%>
<p align="center"><font color="00FF00" size="+3" face="华文行楷">所有教师</font></p>
<p><a href="<%=path %>/jsp/admin/addTeacher.jsp">
<font size="+1" face="华文行楷">增加教师</font>
</a></p>
<div align="center">
	<table width="75%" border="1">
		<tr>
			<td>教师号</td>
			<td>姓名</td>
			<td>职称</td>
			<td>密码</td>
			<td>更新</td>
			<td>删除</td>
		</tr>
<%
	List ls = (List)request.getAttribute("list");
	if(ls != null){
		Iterator iter = ls.iterator();
		while(iter.hasNext()){
			Teacher tea = (Teacher)iter.next();
			String id = tea.getId();
			String name = URLEncoder.encode(tea.getName(), "utf-8");
%>
		<tr>
			<td><%=id %></td>
			<td><%=tea.getName() %></td>
			<td><%=tea.getTitle() %></td>
			<td><%=tea.getPassword() %></td>
			<td><a href="<%=path %>/jsp/admin/updateTeacher.jsp?teaid=<%=id %>&teaname=<%=name%>">更新</a></td>
			<td><a href="<%=path %>/TeacherSvlt?action=remove&tea_id=<%=id %>">删除</a></td>
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