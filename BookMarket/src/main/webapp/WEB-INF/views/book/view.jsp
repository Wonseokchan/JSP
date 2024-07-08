<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<title>도서정보</title>
</head>
<body>
<div class="container py-4">
		<%-- <%@include file="fragments/header.jsp" %> --%>
		<jsp:include page="/WEB-INF/views/fragments/header.jsp"></jsp:include>
		<main>
			<div class="p-5 mb-4 bg-body-tertiary rounded-3">
				<div class="container-fluid py-5">
					<h1 class="display-5 fw-bold">도서 정보</h1>
					<p class="col-md-8 fs-4">BookInfo</p>
				</div>
			</div>
			<div class="row align-itmes-md-stretch text-center">
				<div class="col-md-12">
					<h3 class="fw-bold">${book.title }</h3>
					<div class="row d-flex justify-content-center">
						<img class="col-md-6 rounded" style="width:400px; heigth:600px" src="${pageContext.request.contextPath}/books/image?id=${book.id}" alt="${book.title}의 도서 표지">
					</div>
					<p>${book.description }</p>
					<p>${book.id }</p>
					<p>저자 : ${book.author }</p>
					<p>출판사 : ${book.publisher }</p>
					<p>출판일 : ${book.releaseDate }</p>
					<p>분류 : ${book.category }</p>
					<p>재고수 : ${book.quantity }</p>
					<p>가격 : ${book.price }</p>
					<p>상태 : ${book.condition }</p>
					<p><a href="#" class="btn btn-info">도서주문</a>
					<a href="${pageContext.request.contextPath}/cart/add?id=${book.id}" class="btn btn-success">장바구니</a>
					<a href="${pageContext.request.contextPath}/books/update?id=${book.id}" class="btn btn-warning">수정</a>
					<a href="${pageContext.request.contextPath}/books/delete?id=${book.id}" class="btn btn-danger">삭제</a>
					<a href="${pageContext.request.contextPath}/books" class="btn btn-secondary">도서목록</a></p>
				</div>
			</div>
		</main>
		<%@include file="/WEB-INF/views/fragments/footer.jsp" %>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>