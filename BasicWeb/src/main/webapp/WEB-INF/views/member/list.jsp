<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
현재 로그인 정보 : ${sessionScope.member.name}
<br>
쿠키 로그인 정보 : ${cookie.email.value}
<c:choose>
	<c:when test="${empty sessionScope.member}">
		<div><a href="/signin"><button>로그인</button></a></div>
	</c:when>
	<c:otherwise>
		<div><a href="/signout"><button>로그아웃</button></a></div>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${empty cookie.email.value and empty cookie.password.value}">
		<div><a href="/cookie/signin">쿠키 로그인</a></div>
	</c:when>
	<c:otherwise>
		<div><a href="/cookie/signout">쿠키 로그아웃</a></div>
	</c:otherwise>
</c:choose>

<c:forEach items="${members}" var="member">
	<div>
		<span>${member.id }</span>
		<a href="members/view?id=${member.id}"><span>${member.email }</span></a>
		<span>${member.name }</span>
		<span>${member.registerDate }</span>
	</div>
</c:forEach>	

</body>
</html>