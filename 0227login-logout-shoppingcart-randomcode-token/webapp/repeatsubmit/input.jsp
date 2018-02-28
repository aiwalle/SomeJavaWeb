<%@ page import="java.util.UUID" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- <%
	// 这里的代码最后放到了新的InputServlet中    这里改变后就不能再直接访问input.jsp  而是访问inputServlet
	String token = UUID.randomUUID().toString();
	session.setAttribute("TOKEN_IN_SESSION", token);
	%> --%>

	<form action="/transform" method="post">
		<%-- <input type="hidden" name="token" value="<%=token%>"> --%>
		<input type="hidden" name="token" value="${token}">
		转账金额：<input type="text" name="money"><br>
		<input type="submit" value="转账">
	</form>
</body>
</html>