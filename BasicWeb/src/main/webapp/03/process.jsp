<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름(표현식) :
	<%=request.getParameter("name")%><br /> 
	이름(표현언어, EL) : ${param.name}

</body>
</html>