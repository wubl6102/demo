<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.vo.Score"  errorPage="errorpage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>察看学分</title>
</head>
<body>
<%
	String id = (String)session.getAttribute("id");
	if(id == null){
		response.sendRedirect("/jsp/Longin.jsp");
	}
	String path = getServletContext().getContextPath();
%>
<p><font color="#00FF00" size="+3" face="华文行楷">学生成绩</font></p>
<p>&nbsp;</p>
<table width="463" border="1" align="center">
<tr>
	<td width="207" height="34">课程</td>
	<td width="85">学分</td>
	<td width="149">成绩</td>
</tr>
<%
	String score = null;
	String mark = null;
	int sum = 0;
	List<Score> result = (List<Score>)request.getAttribute("score");
	Iterator iter = result.iterator();
	while(iter.hasNext()){
		Score sc = (Score)iter.next();
		score = sc.getScore();
		mark = sc.getCour_mark();
		if("0".equals(score)){
			score = "成绩未给出";
		}
		
		sum += Integer.parseInt(mark);
%>
<tr>
	<td><%=sc.getCour_name() %></td>
	<td><%=mark %></td>
	<td><%=score %></td>
</tr>
<%
	}
%>
</table>
您的总得分为：<%=sum %>
</body>
</html>




