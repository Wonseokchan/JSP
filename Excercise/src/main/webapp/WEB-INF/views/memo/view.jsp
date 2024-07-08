<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>메모상세</title>
</head>
<body>
<main>
	<div>
		<p>제목 : ${memo.title }</p>
		<p>작성자 : ${memo.writer }</p>
		<p>작성일자 : ${memo.registerDate }</p>
		<p>내용 : ${memo.content }</p>
		<a href="${pageContext.request.contextPath}/memos/update?id=${memo.no}">수정</a>
		<a href="${pageContext.request.contextPath}/memos/delete?id=${memo.no}">삭제</a>
	</div>
</main>
</body>
</html>