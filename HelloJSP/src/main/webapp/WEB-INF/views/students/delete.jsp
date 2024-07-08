<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 페이지</title>
</head>
<body>
	<form action="/students/delete" method="post">
		삭제할 학과명 : <input type="text" name="department" value="${students.department }"><br>
		<button type="submit">전송</button>
	</form>
</body>
</html>