<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.vo.Course,java.net.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>课程更新</title>
</head>
<body>
<%
	String admin_id = (String)session.getAttribute("id");
	if(admin_id == null){
		response.sendRedirect("Login.jsp");
	}
	String path = (String)request.getContextPath();
%>
<p align="center"><font color="00FF00" size="+3" face="华文行楷">所有课程</font></p>
<p><a href="<%=path %>/jsp/admin/addCourse.jsp">
<font size="+1" face="华文行楷">增加课程</font>
</a></p>
<div align="center">
	<table width="75%" border="1">
		<tr>
			<td>课程号</td>
			<td>课程名</td>
			<td>学分</td>
			<td>预修课</td>
			<td>所在系</td>
			<td>更新</td>
			<td>删除</td>
		</tr>
<%
	List ls = (List)request.getAttribute("list");
	if(ls != null){
		Iterator iter = ls.iterator();
		while(iter.hasNext()){
			Course cour = (Course)iter.next();
			String id = cour.getCour_id();
			String name = URLEncoder.encode(cour.getName(), "utf-8");
%>
		<tr>
			<td><%=id %></td>
			<td><%=cour.getName() %></td>
			<td><%=cour.getMark() %></td>
			<td><%=cour.getPrepare() %></td>
			<td><%=cour.getDep() %></td>
			<td><a href="<%=path %>/jsp/admin/updateCourse.jsp?courid=<%=id %>&courname=<%=name%>">更新</a></td>
			<td><a href="<%=path %>/CourseSvlt?&action=remove&cour_id=<%=id %>">删除</a></td>
		</tr>
<%
		}
	}
%>
	</table>
</div>
</body>
<a href="<%=path %>/jsp/admin/admin.jsp">&lt;&lt;Back</a>
</html>