<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员登录</title>
</head>
<body>
<%
	String admin_id = (String)session.getAttribute("id");
	if(admin_id == null){
		response.sendRedirect("Login.jsp");
	}
	String path = (String)request.getContextPath();
%>
<p><font color="#00FF00" size="+2" face="华文行楷">您以成功通过验证！您可以修改以下内容：</font></p>
<table align="center">
	<tr>
		<td><a href="<%=path %>/StudentSvlt?action=display">学生&gt;&gt;</a></td>
		<td><a href="<%=path %>/TeacherSvlt?action=display">教师&gt;&gt;</a></td>
		<td><a href="<%=path %>/CourseSvlt?action=display">课程&gt;&gt;</a></td>
		<td><a href="<%=path %>/ClassesSvlt?action=display">班级&gt;&gt;</a></td>
	</tr>
</table>
<p>&nbsp;</p><p>&nbsp;</p>
<p><a href="<%=path %>/LoginConfirm?action=logout">&lt;&lt;注销</a></p>
</body>
</html>









