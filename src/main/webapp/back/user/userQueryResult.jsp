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
<jsp:useBean id="qr" class="edu.iit.fenghuang.ssh.vo.UserQueryModel" scope="request"></jsp:useBean>
<table width=60% align = "center" border="strike">
	<tr>
		<td colspan="6" align="center">User Query Result</td>
	</tr>
	<tr>
		<td>userId</td>
		<td>password</td>
		<td>firstName</td>
		<td>lastName</td>
		<td>email</td>
		<td>balance</td>
	</tr>
	
	<c:forEach items="${qr.result }" var="um">
		<tr>
			<td><c:out value="${um.userId }"></c:out></td>
			<td><c:out value="${um.password }"></c:out></td>
			<td><c:out value="${um.firstName }"></c:out></td>
			<td><c:out value="${um.lastName }"></c:out></td>
			<td><c:out value="${um.email }"></c:out></td>
			<td><c:out value="${um.balance }"></c:out></td>
		</tr>		
	</c:forEach>
	<tr>
		<td colspan="6">
			<input type="button" value="toList" onclick="window.location.href='${pageContext.servletContext.contextPath}/UserServlet?submitFlag=toList'">
		</td>
	</tr>
</table>


</body>
</html>