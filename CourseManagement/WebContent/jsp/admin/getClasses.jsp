<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.vo.Classes" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>班级更新</title>
</head>
<body>
<%
	String admin_id = (String)session.getAttribute("id");
	if(admin_id == null){
		response.sendRedirect("Login.jsp");
	}
	String path = (String)request.getContextPath();
%>
<p align="center"><font color="00FF00" size="+3" face="华文行楷">所有班级</font></p>
<p><a href="<%=path %>/ClassesSvlt?action=optionAdd">
<font size="+1" face="华文行楷">增加班级</font>
</a></p>
<div align="center">
	<table width="75%" border="1">
		<tr>
			<td>班级号</td>
			<td>教师</td>
			<td>教师号</td>
			<td>课程</td>
			<td>课程号</td>
			<td>教室ID</td>
			<td>上课时间</td>
			<td>更新</td>
			<td>删除</td>
		</tr>
<%
	List ls = (List)request.getAttribute("list");
	if(ls != null){
		Iterator iter = ls.iterator();
		while(iter.hasNext()){
			Classes cls = (Classes)iter.next();
			String id = cls.getId();
%>
		<tr>
			<td><%=id %></td>
			<td><%=cls.getTea_id() %></td>
			<td><%=cls.getTea_name() %></td>
			<td><%=cls.getCour_name() %></td>
			<td><%=cls.getCour_id() %></td>
			<td><%=cls.getRoom_id() %></td>
			<td><%=cls.getCour_time() %></td>
			<td><a href="<%=path %>/ClassesSvlt?&action=optionUpdate&cls_id=<%=id %>">更新</a></td>
			<td><a href="<%=path %>/ClassesSvlt?&action=remove&cls_id=<%=id %>">删除</a></td>
		</tr>
<%
		}
	}
%>
	</table>
</div>
</body>
</html>