<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록 페이지</title>
</head>
<body>
	<form action="/students/new" method="post">
		학번 : <input type="text" name="no"><br>
		학과 : <input type="text" name="department"><br>
		이름 : <input type="text" name="name"><br>
		주소 : <input type="text" name="address"><br>
		연락처 : <input type="tel" name="phone"><br>
		<button type="submit">전송</button>
	</form>
</body>
</html>