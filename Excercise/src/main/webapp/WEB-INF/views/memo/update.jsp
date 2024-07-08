<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>
</head>
<body>
	<form action="/memos/update" method="post">
		제목 : <input type="text" name="title" placehold="제목을입력하세요"><br>
		내용 : <textarea name="content"></textarea>
		작성자 : <input type="text" name="writer"><br>
		
		<button type="submit">저장</button>
	</form>
</body>
</html>