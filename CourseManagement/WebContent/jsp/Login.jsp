<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<script type="text/javascript" src="../js/login.js"></script>
</head>
<body OnLoad="Scroll()">
<form name="tmForm">
<input type="text" name="tmText" size=40 />
</form>
<p>
<%
	String getmessage = (String) session.getAttribute("error");
	if(getmessage == null){
		getmessage = "";
	}
	String path = getServletContext().getContextPath();
%>
</p>
<p><font color="red"><%=getmessage%></font></p>
<p align="center"><font color="#33FF00" size="+4" face="华文行楷">学生课绩管理系统</p>
<form name="frmLogin" method="post" action="<%=path %>/LoginConfirm" onSubmit="return isValid(this);">
	<div align="center">
		<table width="50%" height="232" border=1 align="center">
			<tr>
				<td height="44" colspan="2">
					<div align="center"><font color="#00FFFF" size="+3" face="华文行楷">请你输入</div>
				</td>
			</tr>
			<tr>
				<td><div align="center"><font color="#00FFFF"><strong>用户：</strong></font></div></td>
				<td>
					<input name="kind" type="radio" value="student" checked />学生
					<input name="kind" type="radio" value="teacher">教师
					<input name="kind" type="radio" value="admin">管理员
				</td>
			</tr>
			<tr>
				<td width="32%"><div align="center"><strong><font color="#00FFFF">登录名：</font></strong></div></td>
				<td width="68%"><input name="id" type="text" id="id" size="20" maxlength="20"></td>
			</tr>
			<tr>
				<td><div align="center"><strong><font color="#00FFFF">密码：</font></strong></div></td>
				<td><input name="password" type="password" id="password" size="8" maxlength="8"></td>
			</tr>
			<tr>
				<td colspan="2"><div align="center">
					<input type="submit" name="Submit" value="登陆"/>
				</div></td>
			</tr>
		</table>
	</div>
</form>
</body>
</html>















