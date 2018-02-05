<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" errorPage="/jsp/errorpage.jsp" %>
<%@ page import="java.util.*,com.vo.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>选择学生</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String tea_id = (String) session.getAttribute("id");
	if(tea_id == null){
		response.sendRedirect("/jsp/Longin.jsp");
	}
	String path = request.getContextPath();
%>
<div align="center">
<p>&nbsp;</p>
<p><font color="#00FF00" size="+3" face="方正舒体">选报该课程的学生</font></p>
<table width="75%" border="1">
	<tr>
		<td>学生姓名</td>
		<td>所在系</td>
		<td>性别</td>
		<td>学分</td>
		<td>Email</td>
		<td>Tel</td>
		<td>接受</td>
	</tr>
<%
	String class_id = (String)request.getAttribute("class_id");
	List<Student> list = (List<Student>)request.getAttribute("student");
	Iterator iter = list.iterator();
	while(iter.hasNext()){
		Student stu = (Student)iter.next();
		String stu_id = stu.getId();
		String stu_name = stu.getName();
%>
	<tr>
		<td><%=stu_name %></td>
		<td><%=stu.getDepartment() %></td>
		<td><%=stu.getSex() %></td>
		<td><%=stu.getMark() %></td>
		<td><%=stu.getEmail() %></td>
		<td><%=stu.getTel() %></td>
		<td>
			<a href="<%=path %>/TeacherLoginSvlt?action=enrol&class_id=<%=class_id%>&stu_id=<%=stu_id%>">accept</a>
		</td>	
	</tr>
<%
	}
%>
</table>
<p>&nbsp;</p>
<p align="left"><a href="<%=path %>/jsp/teacher/choosestu.jsp"></a></p>
</div>
</body>
</html>