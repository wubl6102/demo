<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增课程</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String admin_id = (String)session.getAttribute("id");
	if(admin_id == null){
		response.sendRedirect("Login.jsp");
	}
	String path = (String)request.getContextPath();
%>
<div align="center">
<p align="center">新增课程</p>
<form action="<%=path %>/CourseSvlt" method="post">
<input type="hidden" name="action" value="new"/>
<table width="49%" border="1">
	<tr>
		<td widht="48%">课程号</td>
		<td width="52%"><input type="text" name="cour_id"/></td>
	</tr>
	<tr>
		<td>课程名</td>
		<td><input type="text" name="cour_name"/></td>
	</tr>
	<tr>
		<td>学分</td>
		<td><select name="cour_mark" size="1">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select></td>
	</tr>
	<tr>
		<td>系别</td>
		<td><select name="cour_dep" size="1">
			<option>public</option>
			<option>计算机</option>
			<option>机械系</option>
			<option>电子系</option>
			<option>数理系</option>
		</select></td>
	</tr>
	<tr>
		<td>预修课</td>
		<td><select name="cour_pre" size="1">
			<option value="0">无预修课</option>
			<option value="1">预修课</option>
		</select></td>
	</tr>
</table>
<p>&nbsp;</p>
<p align="center">
	<input type="submit" name="Submit" value="确定"/>
</p>
</form>
</div>
<a href="<%=path %>/CourseSvlt?&action=display">&lt;&lt;Back</a>
</body>
</html>




