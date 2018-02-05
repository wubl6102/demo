<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.vo.Course"  errorPage="errorpage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>选报课程</title>
</head>
<body>
<%
	String id = (String)session.getAttribute("id");
	if(id == null){
		response.sendRedirect("/jsp/Longin.jsp");
	}
	String path = getServletContext().getContextPath();
%>
<p align="center"><font color="00FF00" size="+3" face="方正舒体">您可以选报的课程为</font></p>
<table border="1" align="center">
	<tr>
		<td width="54">课程号</td>
		<td width="54">课程名</td>
		<td width="57">预选课</td>
		<td width="58">系别</td>
		<td width="59">班级号</td>
		<td width="69">教室号</td>
		<td width="88">上课时间</td>
		<td width="88">教师</td>
		<td width="83">选择</td>
	</tr>
<%
	List<Course> result = (List<Course>)request.getAttribute("course");
	Iterator iter = result.iterator();
	while(iter.hasNext()){
		Course cour = (Course)iter.next();
		String cour_id = cour.getCour_id();
		String cour_name = cour.getName();
		String cour_pre = cour.getPrepare();
		String cour_dep = cour.getDep();
		String classes_id = cour.getClass_id();
%>
	<tr>
		<td><%=cour_id %></td>
		<td><%=cour_name %></td>
		<td><%=cour_pre %></td>
		<td><%=cour_dep %></td>
		<td><%=classes_id %></td>
		<td><%=cour.getRoom_id() %></td>
		<td><%=cour.getCour_time() %></td>
		<td><%=cour.getTea_name() %></td>
		<td>
			<a href="<%=path %>/StudentLoginSvlt?action=enrol&id=<%=id %>&class_id=<%=classes_id %>&prepare=<%=cour_pre %>">注册</a>
		</td>
	</tr>
<%
	}
%>

</table>
</body>
</html>







