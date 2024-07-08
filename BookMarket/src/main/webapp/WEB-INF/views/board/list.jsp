<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시글 목록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container py-4">
	<jsp:include page="/WEB-INF/views/fragments/header.jsp" />
	<main>
		<a href="${pageContext.request.contextPath }/boards/insert" class="btn btn-primary">게시글 등록</a>
		<table class="table">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>수정일자</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${boards }" var="board">
				<tr>
					<td>${board.no }</td>
					<td><a href="${pageContext.request.contextPath }/boards/view?no=${board.no}">${board.title }</a></td>
					<td>${board.name }</td>
					<td>${board.registerDate }</td>
					<td>${board.modifiedDate }</td>
					<td>${board.hits }</td>
				</tr>
			</c:forEach>
		</table>
	</main>
	<jsp:include page="/WEB-INF/views/fragments/footer.jsp" />
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>