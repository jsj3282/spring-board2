<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../default/header.jsp"/>
	<div align="center">
		<table border="0" style="width:300px;">
		<caption><h1>${memberData.id } 정 보</h1></caption>
			<tr><th>아이디</th><th>${memberData.id }</th></tr>
			<tr><th>비밀번호</th><th>${memberData.pw }</th></tr>
			
		</table>
	</div>
	<c:import url="../default/footer.jsp"/>
</body>
</html>
