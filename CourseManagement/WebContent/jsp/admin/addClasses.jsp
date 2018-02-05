<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.vo.Teacher,com.vo.Course" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增班级</title>
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
<p align="center">新增班级</p>
<form action="<%=path %>/ClassesSvlt" method="post">
<input type="hidden" name="action" value="new"/>
<table width="49%" border="1">
	<tr>
		<td widht="48%">班级号</td>
		<td width="52%"><input type="text" name="cls_id"/></td>
	</tr>
	<tr>
		<td>教师</td>
		<td><select name="tea_id" size="1">
<%
	List tealist = (List)request.getAttribute("tealist");
	Iterator iter = tealist.iterator();
	while(iter.hasNext()){
		Teacher tea = (Teacher)iter.next();
%>
		<option value="<%=tea.getId() %>"><%=tea.getName() %></option>
<%
	}
%>
		</select></td>
	</tr>
	<tr>
		<td>课程</td>
		<td><select name="cour_id" size="1">
<%
	List courlist = (List)request.getAttribute("courlist");
	Iterator iter2 = courlist.iterator();
	while(iter2.hasNext()){
		Course cour = (Course)iter2.next();
%>
		<option value="<%=cour.getCour_id() %>"><%=cour.getName() %></option>
<%
	}
%>
		</select></td>
	</tr>
	<tr>
		<td>课室</td>
		<td><select name="room_id" size="1">
			<option>101</option>
			<option>102</option>
			<option>103</option>
			<option>201</option>
			<option>202</option>
			<option>203</option>
			<option>301</option>
			<option>302</option>
			<option>303</option>
		</select></td>
	</tr>
	<tr>
		<td>上课时间</td>
		<td><select name="cour_time" size="1">
			<option value="Mon_1">星期一/一节</option>
			<option value="Mon_2">星期一/二节</option>
			<option value="Mon_3">星期一/三节</option>
			<option value="Tues_1">星期二/一节</option>
			<option value="Tues_2">星期二/二节</option>
			<option value="Tues_3">星期二/三节</option>
			<option value="Wed_1">星期三/一节</option>
			<option value="Wed_2">星期三/二节</option>
			<option value="Wed_3">星期三/三节</option>
			<option value="Thurs_1">星期四/一节</option>
			<option value="Thurs_2">星期四/二节</option>
			<option value="Thurs_3">星期四/三节</option>
			<option value="Fri_1">星期五/一节</option>
			<option value="Fri_2">星期五/二节</option>
			<option value="Fri_3">星期五/三节</option>
		</select></td>
	</tr>
</table>
<p>&nbsp;</p>
<p align="center">
	<input type="submit" name="Submit" value="确定"/>
</p>
</form>
</div>
<a href="<%=path %>/ClassesSvlt?&action=display">&lt;&lt;Back</a>
</body>
</html>




