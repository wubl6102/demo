<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isErrorPage="true"%>
<%
    response.setStatus(200);
	String path = application.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Error</title>
</head>
<body>
<h1>错误如下</h1>
<h1><%=request.getAttribute("problem") %></h1>
<p>&nbsp;</p><p>&nbsp;</p>
<p><a href="<%=path %>">&lt;&lt;返回</a></p>
</body>
</html>