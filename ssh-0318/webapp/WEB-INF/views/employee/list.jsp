<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="500" cellpadding="0" border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>AGE</th>
			<th>DEPT</th>
		</tr>
		<s:iterator value="#employees">
			<tr>
				<td><s:property value="id"/></td>
				<td><s:property value="name"/></td>
				<td><s:property value="age"/></td>
				<td><s:property value="dept.name"/></td>
				<%-- <td>${dept.name}</td> --%>
			</tr>
		</s:iterator>
	</table>
</body>
</html>