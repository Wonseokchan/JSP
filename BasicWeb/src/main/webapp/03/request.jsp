<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="process.jsp" method="get">
		이름 : <input type="text" name="name">
		<input type="hidden" name="age" value="11">
		<button type="submit">전송</button>
	</form>
</body>
</html>