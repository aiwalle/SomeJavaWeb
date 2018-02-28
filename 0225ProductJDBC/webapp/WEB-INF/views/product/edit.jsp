<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品编辑界面</title>
</head>
<body>
	
	<form action="product?cmd=save" method="post">
		<input type="hidden" name="id" value=${product.id}>
		<table border="1" width="80%" cellpadding="0" cellspacing="0">
			<tr>
				<td>商品名称</td>
				<td>
					<input type="text" name="productName" value="${product.productName}" required>
				</td>
			</tr>
			<tr>
				<td>商品品牌</td>
				<td>
					<input type="text" name="brand" value="${product.brand}"  required>
				</td>
			</tr>
			<tr>
				<td>供应商</td>
				<td>
					<input type="text" name="supplier" value="${product.supplier}"  required>
				</td>
			</tr>
			<tr>
				<td>零售价</td>
				<td>
					<input type="number" name="salePrice" value="${product.salePrice}"  required>
				</td>
			</tr>
			<tr>
				<td>成本价</td>
				<td>
					<input type="number" name="costPrice" value="${product.costPrice}"  required>
				</td>
			</tr>
			<tr>
				<td>折扣</td>
				<td>
					<input type="text" name="cutoff" value="${product.cutoff}"  required>
				</td>
			</tr>
			<tr>
				<td>商品分类</td>
				<td>
					<%-- <select name="dir_id">
						<option value="1" ${product.dir_id == 1 ? "selected":""}>鼠标</option>
						<option value="2" ${product.dir_id == 2 ? "selected":""}>无线鼠标</option>
						<option value="3" ${product.dir_id == 3 ? "selected":""}>有线鼠标</option>
						<option value="4" ${product.dir_id == 4 ? "selected":""}>美女鼠标</option>
					</select> --%>
					
					
					<select name="dir_id">
						<c:forEach items="${productdir}" var="dir">
							<option value="${dir.id}" ${product.dir_id == dir.id ? "selected":""}>${dir.dirName}</option>
						</c:forEach>
					</select>
					
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="保存">
				</td>			
			</tr>
		</table>
	</form>
</body>
</html>