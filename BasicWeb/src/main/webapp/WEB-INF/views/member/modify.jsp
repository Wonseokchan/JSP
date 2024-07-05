<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>
</head>
<body>
	<form action="/members/update" method="post">
		<input type="text" name="id" readonly="readonly" value="${param.id }"><br>
		<input type="email" name="email" value="${member.email }" placeholder="이메일을 입력하세요"><br>
		<input type="password" name="password" value="${member.password }" placeholder="패스워드를 입력하세요"><br>
		<input type="text" name="name" value="${member.name }" placeholder="이름을 입력하세요"><br>
		<button type="submit">수정하기</button>
		<button type="reset">다시쓰기</button>
	</form>
</body>
</html>