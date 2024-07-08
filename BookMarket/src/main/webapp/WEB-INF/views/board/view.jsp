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
		<div class="row my-3">
			<label class="col-md-2 align-content-center" style="text-align: center">제목</label>
			<div class="col-md-5">
				<input type="text" name="title" readonly="readonly" class="form-control" value="${board.title }"/>
			</div>
		</div>
		<div class="row my-3">
			<label class="col-md-2 align-content-center" style="text-align: center">내용</label>
			<div class="col-md-5">
				<textarea class="form-control" name="content" readonly="readonly" rows=7>${board.content}</textarea>
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
				<div class="col-md-7 text-end">
					<a href="${pageContext.request.contextPath}/boards/update?no=${board.no}" class="btn btn-warning">수정</a>
					<a href="#" data-url="${pageContext.request.contextPath}/boards/delete?no=${board.no}" id="deleteBtn" class="btn btn-danger">삭제</a>
					<a href="${pageContext.request.contextPath}/boards" class="btn btn-secondary">게시글목록</a></p>
				</div>
		</div>
	</div>
</main>
<jsp:include page="/WEB-INF/views/fragments/footer.jsp" />
</div>
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
<script>
	deleteBtn.addEventListener("click", (e)=>{
		if(confirm("선택한 게시글을 삭제하시겠습니까?")){
			location.href = e.target.dataset.url
		}else{
			alert("삭제를 취소합니다");			
		}
	})
</script>
</body>
</html>