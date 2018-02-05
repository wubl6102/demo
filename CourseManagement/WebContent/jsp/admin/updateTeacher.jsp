<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.net.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师信息更新</title>
</head>
<%
	request.setCharacterEncoding("utf-8");
	String admin_id = (String)session.getAttribute("id");
	if(admin_id == null){
		response.sendRedirect("Login.jsp");
	}
	String path = (String)request.getContextPath();
	String name = URLDecoder.decode((String)request.getParameter("teaname"),"utf-8");
%>
<div align="center">
<p align="center">更新教师信息</p>
<form action="<%=path %>/TeacherSvlt" method="post">
<input type="hidden" name="action" value="update"/>
<input type="hidden" name="tea_id" value="<%=request.getParameter("teaid") %>"/>
<table width="49%" border="1">
	<tr>
		<td>教师姓名</td>
		<td><input type="text" name="tea_name" value="<%=name %>"/></td>
	</tr>
	<tr>
		<td>密码</td>
		<td><input type="text" name="tea_psw"/></td>
	</tr>
	<tr>
		<td>职称</td>
		<td><select name="tea_title" size="1">
			<option>讲师</option>
			<option>教授</option>
		</select></td>
	</tr>
</table>
<p>&nbsp;</p>
<p align="center">
	<input type="submit" name="Submit" value="确定"/>
</p>
</form>
</div>
<a href="<%=path %>/jsp/admin/getTeacher.jsp">&lt;&lt;Back</a>
</body>
</html>