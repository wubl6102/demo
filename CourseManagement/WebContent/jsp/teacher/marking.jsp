<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	String stu_id = (String)request.getParameter("stu_id");
	String class_id = (String)request.getParameter("class_id");
%>
<div align="center">
<p align="center" ><font color="#00FF00" size="+3" face="方正舒体">学生成绩</font></p>
<p><%=class_id %></p>
<form action="<%=path %>/TeacherLoginSvlt" method="post">
<input type="hidden" name="action" id="marking" value="marking" />
<input type="hidden" name="class_id" id="class_id" value="<%=class_id%>" />
<input type="hidden" name="stu_id" id="stu_id" value="<%=stu_id%>" />
<table width="75%" border="1" align="center">
	<tr>
		<td>学生号</td>
		<td>成绩</td>
	</tr>
	<tr>
		<td><%=stu_id %></td>
		<td><input type="text" name="score" id="score"/></td>
	</tr>
</table>
<p>&nbsp;</p>
<div align="center">
	<input type="submit" name="Submit" value="提交"/>
</div>
</form>
</div>
</body>
</html>









