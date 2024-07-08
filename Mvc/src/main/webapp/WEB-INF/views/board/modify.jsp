<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/boards/modify" method="post">
		<input type="hidden" name="no" readonly="readonly" value="${param.no }"><br>
		제목 : <input type="text" name="title" value="${board.title }"><br>
		내용 : <textarea name="content">${board.content }</textarea><br>
		작성자 : <input type="text" name="writer" value=${board.writer }><br>
		<button type="submit">수정</button>
	</form>
</body>
</html>