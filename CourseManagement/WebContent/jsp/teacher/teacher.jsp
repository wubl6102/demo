<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" errorPage="errorpage" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>teacher</title>
</head>
<body>
<%
	String tea_id = (String)session.getAttribute("id");
	if(tea_id == null){
		response.sendRedirect("/jsp/Longin.jsp");
	}
	String path = (String)request.getContextPath();
%>
<p align="center"><font color="#00FF00" size="+3" face="方正舒体">您已经成功登陆，请您选择以下功能：</font></p>
<p align="center">
	<a href="<%=path %>/TeacherLoginSvlt?id=<%=tea_id %>&action=choosestu">挑选您的学生&gt;&gt;</a>
	<a href="<%=path %>/TeacherLoginSvlt?id=<%=tea_id %>&action=publish">公布成绩&gt;&gt;</a>
</p>
<p align="center">&nbsp;</p>
<p align="center">&nbsp;</p>
<p><a href="<%=path %>/LoginConfirm?action=logout">&lt;&lt;注销</a></p>
</body>
</html>
























