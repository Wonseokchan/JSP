<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 상세 페이지</title>
</head>
<body>
<c:choose>
    <c:when test="${board != null}">
        게시글 번호 : <div>${board.no}</div>
        제목 : <div>${board.title}</div>
        내용 : <div>${board.content}</div>
        작성자 : <div>${board.writer}</div>
        등록일자 : <div>${board.registerDate}</div>
        수정일자 : <div>${board.modifiedDate}</div>
        조회수 : <div>${board.hits}</div>
        <div>
        	<a href="${pageContext.request.contextPath}/boards/modify?no=${board.no}"><button	>수정</button></a>
        	<form action="${pageContext.request.contextPath}/boards/remove" method="post">
        		<input type="hidden" name="no" value="${board.no }">
        		<button>삭제</button>
        	</form>
        </div>
    </c:when>
    <c:otherwise>회원이 존재하지 않습니다</c:otherwise>
</c:choose>

</body>
</html>