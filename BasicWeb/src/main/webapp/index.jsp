<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<String> list = new ArrayList();
	list.add("홍길동");
	list.add("이순신");
	%>
	안녕
	<%=LocalDateTime.now()%> <br />
	리스트의 전체 갯수:
	<%=list.size()%>
</body>
</html>