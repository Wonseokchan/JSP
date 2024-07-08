<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<title>도서 목록</title>
</head>
<body>
	<div class="container py-4">
		<jsp:include page="/WEB-INF/views/fragments/header.jsp" />
		<main>
			<div class="p-5 mb-4 bg-body-tertiary rounded-3">
				<div class="container-fluid py-5">
					<h1 class="display-5 fw-bold">도서 목록</h1>
					<p class="col-md-8 fs-4">BookList</p>
				</div>
			</div>
		
			<div class="row align-itmes-md-stretch text-center">
				<c:forEach items="${books}" var="book">
					<div class="col-md-4">
						<div class="h-100 p-2">
							<h5 class="fw-bold">${book.title }</h5>
							<p>${book.author }</p>
							<p>${book.publisher } | ${book.price }</p>
							<p>${book.description }</p>
							<p>${book.price }</p>
							<p><a href="${pageContext.request.contextPath}/books/view?id=${book.id}" class="btn btn-secondary">상세정보 &raquo;</a></p>
						</div>
					</div>
				</c:forEach>
			</div>
		</main>
		<jsp:include page="/WEB-INF/views/fragments/footer.jsp" />
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>