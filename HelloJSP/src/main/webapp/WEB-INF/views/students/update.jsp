<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>
</head>
<body>
	<form action="/students/update" method="post">
		변경전 학과명 : <input type="text" name="department" readonly="readonly" value="${param.department }"><br>
		변경후 학과명 : <input type="text" name="department" value="${students.department }"><br>
		<button type="submit">전송</button>
	</form>
</body>
</html>