<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表界面</title>
</head>
<body>
	<!-- <a href="/person/edit">添加学生</a> -->
	<a href="${pageContext.request.contextPath}/person?cmd=edit">添加学生</a>
	<table border="1" width="80%" cellpadding="0" cellspacing="0">
		<tr style="background-color: yellow">
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${people}" var="p" varStatus="vs">
			<tr style='background-color: ${vs.count % 2 == 0 ?"gray":""};'>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.age}</td>
				<td>
					<%-- <a href="/person/delete?id=${p.id}">删除</a> |
					<a href="/person/edit?id=${p.id}">编辑</a> --%>
				
					<a href="${pageContext.request.contextPath}/person?cmd=delete&id=${p.id}">删除</a> |
					<a href="${pageContext.request.contextPath}/person?cmd=edit&id=${p.id}">编辑</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>