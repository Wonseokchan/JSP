<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${students}" var="students">
		<div>
			<span>${students.no }</span>
			<a href="students/view?id=${students.no}"><span>${students.department }</span></a>
			<span>${students.name }</span>
			<span>${students.address }</span>
			<span>${students.phone }</span>
		</div>
	</c:forEach>	
</body>
</html>