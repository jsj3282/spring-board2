<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../default/header.jsp"/>
	<div align="center">
		<table border="1" style="width:500px;">
		<caption><h1>회 원 정 보</h1></caption>
			<tr><th>아이디</th><th>비밀번호</th></tr>
			<c:forEach items="${members }" var="mem">
				<tr>
				<td><a href="info?id=${mem.id }">${mem.id }</a></td>
				<td>${mem.pw }</td></tr>
			</c:forEach>
		</table>
	</div>
	<c:import url="../default/footer.jsp"/>
</body>
</html>

	
