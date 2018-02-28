<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// 销毁session
	session.invalidate();
	%>
	<h3>用户登录</h3>
	<div style="color:red">
		${errorMsg}	
	</div>
	<form action="/login" method="post">
		账户：<input type="text" name="username" required><br>
		密码：<input type="text" name="password" required><br>
		<input type="submit" value="登录">
	</form>
</body>
</html>