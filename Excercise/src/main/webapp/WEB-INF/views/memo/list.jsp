<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="${pageContext.request.contextPath }/memos/new">메모 등록</a>
	</div>
	<div>
		<p>글번호</p>
		<p>제목</p>
		<p>작성자</p>
		<p>작성일자</p>
	</div>
	<c:forEach items="${memos}" var="memos">
		<div>
			<span>${memos.no }</span>
			<a href="memos/view?id=${memos.no}"><span>${memos.title }</span></a>
			<span>${memos.writer }</span>
			<span>${memos.registerDate }</span>
		</div>
	</c:forEach>	
</body>
</html>