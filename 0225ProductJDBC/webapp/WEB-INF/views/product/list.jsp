<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/product?cmd=edit">添加商品</a>
	<table border="1" width="80%" cellpadding="0" cellspacing="0">
		<tr style="background-color: orange">
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品品牌</th>
			<th>商品分类</th>
			<th>供应商</th>
			<th>零售价</th>
			<th>成本价</th>
			<th>折扣</th>
			<th>操作</th>
		</tr>
		
		<c:forEach items="${products}" var="p" varStatus="vs">
			<tr style='background-color: ${vs.count % 2 == 0 ? "gray":""}'>
				<td>${p.id}</td>
				<td>${p.productName}</td>
				<td>${p.brand}</td>
				<td>${p.dir_id}</td>
				<td>${p.supplier}</td>
				<td>${p.salePrice}</td>
				<td>${p.cutoff}</td>
				<td>${p.costPrice}</td>
				<td>
					<a href="/product?cmd=delete&id=${p.id}">删除</a> | 
					<a href="/product?cmd=edit&id=${p.id}">编辑</a>
				</td>
			</tr>
		</c:forEach>
			
	</table>
</body>
</html>