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
<jsp:useBean id="lr" class="edu.iit.fenghuang.ssh.vo.UserQueryModel" scope="request"></jsp:useBean>
<table width=60% align = "center" border="strike">
	<tr>
		<td colspan="7" align="center">User List</td>
	</tr>
	<tr>
		<td><b>userId</b></td>
		<td><b>password</b></td>
		<td><b>firstName</b></td>
		<td><b>lastName</b></td>
		<td><b>email</b></td>
		<td><b>balance</b></td>
		<td><b>Operation</b></td>
	</tr>
	<c:forEach items="${lr.result }" var="um">
		<tr>
			<td><c:out value="${um.userId }"></c:out></td>
			<td><c:out value="${um.password }"></c:out></td>
			<td><c:out value="${um.firstName }"></c:out></td>
			<td><c:out value="${um.lastName }"></c:out></td>
			<td><c:out value="${um.email }"></c:out></td>
			<td><c:out value="${um.balance }"></c:out></td>
			<td><a onclick="return confirm('delete this item?');" href="${pageContext.servletContext.contextPath}/UserServlet?submitFlag=toDelete&userId=${um.userId}">Delete</a>/<a href="${pageContext.servletContext.contextPath}/UserServlet?submitFlag=toUpdate&userId=${um.userId}">Update</a></td>

		</tr>		
	</c:forEach>
	<tr>
		<td colspan="7" align="center">
			<input type="button" value="Create" onclick="window.location.href='${pageContext.servletContext.contextPath}/back/user/userCreate.jsp'">
			<input type="button" value="Query" onclick="window.location.href='${pageContext.servletContext.contextPath}/back/user/userQuery.jsp'">
		</td>
	</tr>
</table>
</body>
</html>