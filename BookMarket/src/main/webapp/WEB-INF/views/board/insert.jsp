<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
<div class="container py-4">
<jsp:include page="/WEB-INF/views/fragments/header.jsp" />
<main>
	<div class="align-items-md-stretch">
		<form action="${pageContext.request.contextPath}/boards/insert" method="post">
			<div class="row my-3">
				<label class="col-md-2 align-content-center" style="text-align: center">제목</label>
				<div class="col-md-5">
					<input type="text" name="title" class="form-control" />
				</div>
			</div>
			<div class="row my-3">
				<label class="col-md-2 align-content-center" style="text-align: center">내용</label>
				<div class="col-md-5">
					<textarea class="form-control" name="content" rows=7></textarea>
				</div>
			</div>
			<div class="row my-3">
				<label class="col-md-2 align-content-center" style="text-align: center">첨부파일</label>
				<div class="col-md-5 d-grid">
					<div class="input-group">
						<label class="input-group-tex" for="files"></label>
						<input type="file" class="form-control" id="files" name="files">
					</div>
				</div>
			</div>
			<div class="row my-3">
				<div class="col-md-7 d-grid">
					<button type="submit" class="btn btn-primary">등록</button>
				</div>
			</div>
		</form>
	</div>
</main>
<jsp:include page="/WEB-INF/views/fragments/footer.jsp" />
</div>
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</body>
</html>