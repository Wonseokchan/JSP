<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<h3>회원 가입</h3>
	<form action="form02_process.jsp" method="post" style="border: 1px solid; padding:10px; width:30%">
		<p>
			<label>이름 : <input type="text" name="name"></label>
		</p>
		<p>
			<label>주소 : <input type="text" name="address"></label>
		</p>
		<p>
			<label>이메일 : <input type="email" name="email"></label>
		</p>
		<p>
			전송 : <button>전송</button>
		</p>
	</form>
</body>
</html>