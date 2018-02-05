<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.net.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息更新</title>
</head>
<%
	request.setCharacterEncoding("utf-8");
	String admin_id = (String)session.getAttribute("id");
	if(admin_id == null){
		response.sendRedirect("Login.jsp");
	}
	String path = (String)request.getContextPath();
	String name = URLDecoder.decode((String)request.getParameter("stuname"),"utf-8");
%>
<div align="center">
<p align="center">更新学生信息</p>
<form action="<%=path %>/StudentSvlt" method="post">
<input type="hidden" name="action" value="update"/>
<input type="hidden" name="stu_id" value="<%=request.getParameter("stuid") %>"/>
<table width="49%" border="1">
	<tr>
		<td>学生姓名</td>
		<td><input type="text" name="stu_name" value="<%=name %>"/></td>
	</tr>
	<tr>
		<td>密码</td>
		<td><input type="text" name="stu_psw"/></td>
	</tr>
	<tr>
		<td>学生所在系</td>
		<td><select name="stu_dep" size="1" name="stu_dep">
			<option>计算机</option>
			<option>机械系</option>
			<option>电子系</option>
			<option>数理系</option>
		</select></td>
	</tr>
	<tr>
		<td>性别</td>
		<td><select name="stu_sex" size="1" name="stu_sex">
			<option>男</option>
			<option>女</option>
		</select></td>
	</tr>
	<tr>
		<td>籍贯</td>
		<td><select name="stu_native" size="1" name="stu_native">
			<option>陕西</option>
			<option>河南</option>
			<option>山东</option>
			<option>内蒙古</option>
			<option>河北</option>
			<option>江苏</option>
		</select></td>
	</tr>
</table>
<p>&nbsp;</p>
<p align="center">
	<input type="submit" name="Submit" value="确定"/>
</p>
</form>
</div>
<a href="<%=path %>/jsp/admin/getStudent.jsp">&lt;&lt;Back</a>
</body>
</html>