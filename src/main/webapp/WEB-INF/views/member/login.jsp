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
<div align="center"><h1>로그인 페이지 입니다</h1></div>
<div align="right">
    <form action="user_check" method="post">
        <table>
			<tr>
			<td><input type="text" name="id" placeholder="아이디"></td>
			<td rowspan="2">
			<input type="submit" value="로그인"style="width:60px;height:55px;">
			</td></tr>
			<tr><td><input type="text" name="pw" placeholder="비밀번호"></td></tr>
			<tr>
				<td colspan="2" align="left">
					<a href="register_form">회원가입</a>
				</td>
			</tr>
        </table>
    </form>
</div>
<c:import url="../default/footer.jsp"/>

</body>
</html>
