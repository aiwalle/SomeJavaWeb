<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>购物车列表</h3>
	<hr>
	<table border="1" width="80%" cellpadding="0" cellspacing="0">
		<tr>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品数量</th>
			<th>操作</th>
		</tr>
		<c:if test="${!empty SHOPPINGCART_IN_SESSION.items}">
			<c:forEach items="${SHOPPINGCART_IN_SESSION.items}" var="it">
			<tr>
				<td>${it.id}</td>
				<td>${it.name}</td>
				<td>${it.price}</td>
				<td>${it.num}</td>
				<td>
					<a href="/shoppingcart?cmd=delete&id=${it.id}">删除</a>
				</td>
			</tr>
			</c:forEach>
			<tr align="right">
				<td colspan="5">购物车总价:${SHOPPINGCART_IN_SESSION.totalPrice}</td>
			</tr>
		</c:if>
		<c:if test="${empty SHOPPINGCART_IN_SESSION.items}">
			<tr>
				<td colspan="5" align="center">亲，你的购物车为空，<a href="/shoppingcart/product_list.jsp">去购物</a></td>
			</tr>
		</c:if>
		
	</table>
	<a href="/shoppingcart/product_list.jsp">去购物</a>
</body>
</html>