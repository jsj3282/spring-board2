<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../default/header.jsp"/>
	<div align="center">
		<table border="1" style="width:500px;">
		<caption><h1>로 그 정 보</h1></caption>
			<tr><th>번호</th><th>아이디</th><th>접속</th>
			<th>종료</th><th>사용시간</th></tr>
			<c:forEach items="${logList }" var="log">
				<tr>
				<td>${log.num }</td><td>${log.id }</td>
				<td>${log.starttime }</td><td>${log.endtime }</td>
				<td>${log.resulttime }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5">
					<c:if test="${start>1 }">
						<a href="userlog?start=${start-1 }">이전</a>
					</c:if>
					<c:forEach items="${arrTot }" var="num">
						<a href="userlog?start=${num }">[${num }]</a>
					</c:forEach>
					<c:if test="${start<totPage }">
						<a href="userlog?start=${start+1 }">다음</a>
					</c:if>
				(${start }/${totPage })
				</td>
			</tr>
		</table>
	</div>
	<c:import url="../default/footer.jsp"/>
</body>
</html>
