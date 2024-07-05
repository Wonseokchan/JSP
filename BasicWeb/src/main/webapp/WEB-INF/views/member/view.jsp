<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 등록 페이지</title>
</head>
<body>
<c:choose>
    <c:when test="${member != null}">
        <div>${member.id}</div>
        <div>${member.email}</div>
        <div>${member.name}</div>
        <div>${member.registerDate}</div>
        <div>
        	<a href="/members/update?id=${member.id}"><button>수정</button></a>
        	<form action="/members/delete" method="post">
        		<input type="hidden" name="id" value="${member.id }">
        		<button>삭제</button>
        	</form>
        </div>
    </c:when>
    <c:otherwise>회원이 존재하지 않습니다</c:otherwise>
</c:choose>

</body>
</html>