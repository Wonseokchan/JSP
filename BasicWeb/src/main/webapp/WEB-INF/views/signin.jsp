<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/signin" method="post">
	<p>
		<label>이메일 : 
			<input name ="email" value="${rememberId }">
		</label>
	</p>
	<p>
		<label>비밀번호 : 
			<input type="password"name ="password">
		</label>
	</p>
	<p>
		<label>
			<input type="checkbox" name="rememberId" value="true" ${rememberId != null ? 'checked' : '' }> ID 저장
		</label>
	</p>
	<p style="color:red;">${msg }</p>
	<p>
		<button>세션 로그인</button>
		<button type="button" id="cookieLogin">쿠키 로그인</button>
	</p>
	
</form>
<script>
	document.querySelector("#cookieLogin").addEventListener("click", evt => {
		document.forms[0].action = "/cookie/signin";
		document.forms[0].submit();
	});
</script>
</body>
</html>