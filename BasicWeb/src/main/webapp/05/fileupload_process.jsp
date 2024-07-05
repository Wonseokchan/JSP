<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	Collection<Part> parts = request.getParts();
	for(Part part: parts){
		out.println("<br> name = " + part.getName());
		out.println("<br> content-type = " + part.getContentType());
		if(part.getHeader("Content-Disposition").contains("filename=")){
			//파일 정보 출력
			out.println("<br> file size : " + part.getSize());
			out.println("<br> file name : " + part.getSubmittedFileName());
			part.write("c:\\uploads\\" + part.getSubmittedFileName());
		}
		else{
			out.println("<br> value = " + request.getParameter(part.getName()));
		}
	}

%>