<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<title>카트 목록</title>
</head>
<body>
	<div class="container py-4">
		<jsp:include page="/WEB-INF/views/fragments/header.jsp" />
		<main>
			<table>
				<tr>
					<th>번호</th>
					<th>도서명</th>
					<th>가격</th>
					<th>수량</th>
					<th>합계</th>
				</tr>
				<c:forEach items="${sessionScope.carts }" var="cart">
					<tr>
						<td>${cart.no }</td>
						<td>${cart.book.title }</td>
						<td>${cart.book.price }</td>
						<td>${cart.quantity }</td>
						<td>${cart.book.price * cart.quantity }</td>
					</tr>
				</c:forEach>
			</table>
		</main>
		<a href="${pageContext.request.contextPath }" class="btn btn-primary">도서 계속 구매하기</a>
		<jsp:include page="/WEB-INF/views/fragments/footer.jsp" />
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>