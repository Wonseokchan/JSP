<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록 페이지</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/boards/register" method="post">
		제목 : <input type="text" name="title"><br>
		내용 : <textarea name="content"></textarea><br>
		작성자 : <input type="text" name="writer"><br>
		<button type="submit">등록</button>
	</form>
</body>
</html>