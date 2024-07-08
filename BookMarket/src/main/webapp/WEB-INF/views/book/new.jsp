<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<title>도서 등록</title>
</head>
<body>
	<div class="container py-4">
		<jsp:include page="/WEB-INF/views/fragments/header.jsp"></jsp:include>
		<main>
			<div class="p-5 mb-4 bg-body-tertiary rounded-3">
				<div class="container-fluid py-5">
					<h1 class="display-5 fw-bold">도서 등록</h1>
					<p class="col-md-8 fs-4">Book Addition</p>
				</div>
			</div>
			<div class="align-items-md-stretch">
				<form action="${pageContext.request.contextPath}/books/insert" method="post" enctype="multipart/form-data">
					<div class="row my-3">
						<label class="col-md-2 align-content-center" style="text-align: center">도서코드</label>
						<div class="col-md-5">
							<input type="text" name="id" class="form-control" />
						</div>
					</div>
					<div class="row my-3">
						<label class="col-md-2 align-content-center" style="text-align: center">도서명</label>
						<div class="col-md-5">
							<input type="text" name="title" class="form-control" />
						</div>
					</div>
					<div class="row my-3">
						<label class="col-md-2 align-content-center" style="text-align: center">가격</label>
						<div class="col-md-5">
							<input type="number" step="1000" name="price" class="form-control" />
						</div>
					</div>
					<div class="row my-3">
						<label class="col-md-2 align-content-center" style="text-align: center">저자</label>
						<div class="col-md-5">
							<input type="text" name="author" class="form-control" />
						</div>
					</div>
					<div class="row my-3">
						<label class="col-md-2 align-content-center" style="text-align: center">출판사</label>
						<div class="col-md-5">
							<input type="text" name="publisher" class="form-control" />
						</div>
					</div>
					<div class="row my-3">
						<label class="col-md-2 align-content-center" style="text-align: center">출판일</label>
						<div class="col-md-5">
							<input type="date" name="releaseDate" class="form-control" />
						</div>
					</div>
					<div class="row my-3">
						<label class="col-md-2 align-content-center" style="text-align: center">상세정보</label>
						<div class="col-md-5">
							<textarea class="form-control" name="description"></textarea>
						</div>
					</div>
					<div class="row my-3">
						<label class="col-md-2 align-content-center" style="text-align: center">분류</label>
						<div class="col-md-5">
							<input type="text" name="category" class="form-control" />
						</div>
					</div>
					<div class="row my-3">
						<label class="col-md-2 align-content-center" style="text-align: center">재고수</label>
						<div class="col-md-5">
							<input type="number" name="quantity" class="form-control" />
						</div>
					</div>
					<div class="row my-3">
						<label class="col-md-2 align-content-center" style="text-align: center">상태</label>
						<div class="col-md-5">
							<input type="radio" name="condition" value="New" class="btn-check" id="new" autocomplete="off" /> <label
								for="new" class="btn btn-outline-primary"
							>신규도서</label> <input type="radio" name="condition" value="Old" class="btn-check" id="old" autocomplete="off" /> <label
								for="old" class="btn btn-outline-secondary"
							>중고도서</label> <input type="radio" name="condition" value="EBook" class="btn-check" id="ebook" autocomplete="off" /> <label
								for="ebook" class="btn btn-outline-success"
							>E-Book</label>
						</div>
					</div>
					<div class="row my-3">
						<label class="col-md-2 align-content-center" style="text-align: center">도서이미지</label>
						<div class="col-md-5 d-grid">
							<div class="input-group">
								<label class="input-group-tex" for="imageFile"></label>
								<input type="file" class="form-control" id="imageFile" name="imageFile">
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
		<jsp:include page="/WEB-INF/views/fragments/footer.jsp"></jsp:include>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>