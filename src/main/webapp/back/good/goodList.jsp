<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="edu.iit.fenghuang.ssh.vo.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<table width=60% align = "center" border="strike">
	<tr>
		<td colspan="5" align="center">Good List</td>
	</tr>
	<tr>
		<td><b>goodId</b></td>
		<td><b>name</b></td>
		<td><b>description</b></td>
		<td><b>price</b></td>
		<td><b>Operation</b></td>
	</tr>
	<c:forEach items="${ret.result }" var="gm">
		<tr>
			<td><c:out value="${gm.goodId }"></c:out></td>
			<td><c:out value="${gm.name }"></c:out></td>
			<td><c:out value="${gm.description}"></c:out></td>
			<td><c:out value="${gm.price }"></c:out></td>
			<td><a onclick="return confirm('delete this item?');" href="${pageContext.servletContext.contextPath}/ssh/goodAction.action?submitFlag=toDelete&gqm.goodId=${gm.goodId}">Delete</a>/<a href="${pageContext.servletContext.contextPath}/ssh/goodAction.action?submitFlag=toUpdate&gqm.goodId=${gm.goodId}">Update</a></td>

		</tr>		
	</c:forEach>
	<tr>
		<td colspan="5" align="center">
			<input type="button" value="Create" onclick="window.location.href='${pageContext.servletContext.contextPath}/back/good/goodCreate.jsp'">
			<input type="button" value="Query" onclick="window.location.href='${pageContext.servletContext.contextPath}/back/good/goodQuery.jsp'">
		</td>
	</tr>
</table>
</body>
</html>