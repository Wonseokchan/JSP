<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	request.setCharacterEncoding("utf-8");
	
	// 폼 데이터를 한번에 받기
	Enumeration<String> parameterNames = request.getParameterNames();
	while(parameterNames.hasMoreElements()){
		String param = parameterNames.nextElement();
		String paramValue = request.getParameter(param);
		out.println(param +" : "+paramValue);
		out.println("<br>");
	}
%>
</body>
</html>