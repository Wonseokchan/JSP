<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 페이지</title>
</head>
<body>
	<div>
		<a href="${pageContext.request.contextPath }/boards/register">게시글 등록</a>
	</div>
	<div>
		<span>번호</span>
		<span>제목</span>
		<span>작성자</span>
		<span>등록일자</span>
		<span>조회수</span>
	</div>
	<c:forEach items="${boards}" var="board">
		<div>
			<span>${board.no }</span>
			<a href="boards/detail?no=${board.no}"><span>${board.title }</span></a>
			<span>${board.writer }</span>
			<span>${board.registerDate }</span>
			<span>${board.hits }</span>
		</div>
	</c:forEach>	
</body>
</html>