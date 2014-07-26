<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@page import="edu.iit.fenghuang.ssh.vo.*"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="s" uri="/struts-tags"%>
	<table width=60% align="center" border="strike">
		<tr>
			<td colspan="4" align="center">User Query Result</td>
		</tr>
		<tr>
			<td>goodId</td>
			<td>name</td>
			<td>description</td>
			<td>price</td>
		</tr>

		<s:iterator value="ret.result">
			<tr>
				<td><s:property value="goodId" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="description" /></td>
				<td><s:property value="price" /></td>
			</tr>
		</s:iterator>

		<tr>
			<td colspan="6" align="center"><input type="button"
				value="toList"
				onclick="window.location.href='${pageContext.servletContext.contextPath}/ssh/goodAction.action?submitFlag=toList'">
			</td>
		</tr>
	</table>


</body>
</html>