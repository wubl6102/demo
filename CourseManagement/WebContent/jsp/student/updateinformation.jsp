<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" errorPage="errorpage"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>更新信息</title>
</head>
<body>
<%
	String stu_id = (String)session.getAttribute("id");
	if(stu_id == null){
		response.sendRedirect("../Login.jsp");
	}
	String path = getServletContext().getContextPath();
%>

<p align="center">
	<font color="#00FF00" size="+3" face="方正舒体">更改你的个人信息</font>
</p>

<form name="form1" method="post" action="<%=path%>/StudentLoginSvlt">
	<input type="hidden" name="action" value="update" />
	<input type="hidden" name="id" value="<%=stu_id %>" />
	<table width="55%" border=1 align="center">
		<tr>
			<td>新密码：</td>
			<td><input name="password1" type="password" id="password1" /></td>
		</tr>
		<tr>
			<td width="42%">密码确认：</td>
			<td width="58%">
				<input name="password2" type="password" id="password2" />
			</td>
		</tr>
		<tr>
			<td>电话：</td>
			<td><input name="tel" type="text" id="tel" /></td>
		</tr>
		<tr>
			<td>E_mail:</td>
			<td><input name="email" type="text" id="email"/></td>
		</tr>
	</table>
	<p align="center"><label></label></p>
	<p align="center">&nbsp;</p>
	<p align="center">
		<input type="submit" name="Submit" value="提交"/>
	</p>
</form>
</body>
</html>





















