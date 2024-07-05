<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<h3>회원 가입</h3>
	<form action="/form" method="post" style="border: 1px solid; padding:10px; width:30%">
		<p>
			<label>아이디 : <input type="text" name="userID"></label>
			<button type="button">아이디 중복 검사</button>
		</p>
		<p>
			<label>비밀번호 : <input type="password" name="userPW"></label>
		</p>
		<p>
			<label>이름 : <input type="text" name="userName"></label>
		</p>
		<p>
			연락처 : 
			<select name="phone1">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="017">017</option>
			<option value="018">018</option>
			<option value="019">019</option>
			</select>
			<input type="tel" name="phone2" size="4" maxlength="4"> -
			<input type="tel" name="phone3" size="4" maxlength="4">
			
		</p>
		<p>
			성별 : 
			<input type="radio" name="gender" value="남자" id="man"><label for="man">남</label>
			<input type="radio" name="gender" value="여자" id="woman"><label for="woman">여</label>

		<p>
			취미 : 
			<label><input type="checkbox" name="hobby" value="독서">독서</label>
			<label><input type="checkbox" name="hobby" value="운동">운동</label>
			<label><input type="checkbox" name="hobby" value="영화">영화</label>
		</p>
		<p>
			<textarea rows="5" cols="30" name="greeting" placeholder="가입인사를 반드시 입력해주세요"></textarea>
		</p>
		<p>
			<button type="submit">가입하기</button>
			<button type="reset">다시쓰기</button>
		</p>
	</form>
</body>
</html>