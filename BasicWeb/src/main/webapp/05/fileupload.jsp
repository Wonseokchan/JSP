<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 MultipartRequest 이용</title>
</head>
<body>
	<form action="/fileupload" method="post" enctype="multipart/form-data">
		<input type="text" name="title">
		<input type="file" name="files">
		<button type="submit">파일 전송</button>
	</form>
</body>
</html>