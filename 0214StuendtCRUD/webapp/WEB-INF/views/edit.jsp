<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- <form action="/person/save" method="post"> -->
	<form action="${pageContext.request.contextPath}/person?cmd=save" method="post">
	<input type="hidden" name="id" value="${person.id}">
	姓名：<input type="text" name="name" value="${person.name}" required><br>
	年龄：<input type="number" name="age" value="${person.age}" required><br>
	<input type="submit" value='${person == null ? "保存学生信息":"更新学生信息"}'>
	</form>
</body>
</html>