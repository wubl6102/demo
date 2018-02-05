<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Student</title>
</head>
<body>
<%
	String id = (String)session.getAttribute("id");
	if(id == null){
		response.sendRedirect("/jsp/Longin.jsp");
	}
	String path = getServletContext().getContextPath();
%>

<p><font size="+2" face="华文行楷">您已经成功通过验证！您可以使用如下服务：</font></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="58%" border="0" align="center">
	<tr>
		<td><a href="<%=path %>/StudentLoginSvlt?id=<%=id%>&action=display">选修课程</a></td>
		<td><a href="<%=path %>/StudentLoginSvlt?id=<%=id%>&action=checkmark">察看学分</a></td>
		<td><a href="<%=path %>/jsp/student/updateinformation.jsp">更改信息</a></td>
	</tr>
</table>
<p>&nbsp;</p><p>&nbsp;</p>
<p><a href="<%=path %>/LoginConfirm?action=logout">&lt;&lt;注销</a></p>
</body>
</html>


















