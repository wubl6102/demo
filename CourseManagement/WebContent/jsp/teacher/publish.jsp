<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" errorPage="errorpage.jsp" %>
<%@ page import="java.util.*,com.vo.Course" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公布成绩</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String id = (String)session.getAttribute("id");
	if(id == null){
		response.sendRedirect("/jsp/Longin.jsp");
	}
	String path = request.getContextPath();
%>
<div align="center">
<p><font color="#00FF00" size="+3" face="方正舒体">
	选择公布的课程</font></p>
<p>&nbsp;</p>
<table widht="75%" border="1" >
	<tr>
		<td>班级号</td>
		<td>课程表</td>
		<td>时间</td>
		<td>选择</td>
	</tr>
<%
	List<Course> list = (List<Course>)request.getAttribute("course");
	Iterator iter = list.iterator();
	while(iter.hasNext()){
		Course cour = (Course)iter.next();
		String class_id = cour.getClass_id();
		String cour_name = cour.getName();
		String cour_time = cour.getCour_time();
%>
	<tr>
		<td><%=class_id %></td>
		<td><%=cour_name %></td>
		<td><%=cour_time %></td>
		<td>
		<a href="<%=path %>/TeacherLoginSvlt?action=score&class_id=<%=class_id %>&cour_time=<%=cour_time%>">选择</a>
		</td>
	</tr>
<%
	}
%>
</table>
</div>
<p>&nbsp;</p>
<p align="left"><a href="<%=path %>/jsp/teacher/teacher.jsp">&lt;&lt;Back</a></p>
</body>
</html>










