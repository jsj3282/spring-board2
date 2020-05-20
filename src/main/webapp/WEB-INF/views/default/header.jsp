<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style type="text/css">
		ul li{	display:inline;	padding:0 10px; }
	</style>
</head>
<body>
	<div align="center" >
		<h1 style="color:burlywood; font-size:60px; font-family:Gabriola;">
			CARE &nbsp; LAB
		</h1>
	</div>
	<div align="right">
		<hr>
		<ul>
			<li><a href="index">HOME</a></li>
			<li>
				<c:if test = '${userId != null}'>
					<a href="memberInfo">회원 정보</a>
				</c:if>
				<c:if test = '${userId == null}'>
					<a href="login">회원 정보</a>
				</c:if>
			</li>
			<li>
				<c:if test = '${userId != null}'>
					<a href="userlog">로그보기</a>
				</c:if>
				<c:if test = '${userId == null}'>
					<a href="login">로그보기</a>
				</c:if>
			</li>
			<li>
				<c:if test = '${userId != null}'>
					<a href="logout">로그아웃</a>
				</c:if>
				<c:if test = '${userId == null}'>
					<a href="login">로그인</a>
				</c:if>
			</li>
		</ul>
		<hr>
	</div>
</body>
</html>
