<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="uqm" class="edu.iit.fenghuang.ssh.vo.UserQueryModel" scope="request"/>
<jsp:setProperty property="*" name="uqm"/>



<c:if test="${uqm.submitFlag == 'toQuery' }">
	<jsp:forward page="/UserServlet"></jsp:forward>
</c:if>
<form action="userQuery.jsp" method="post" >
<input type="hidden" name=submitFlag value="toQuery"/>
<table width=25% align="center" border="strike">
	<tr>
		<td colspan="2" align="center">
		<b>USER QUERY PAGE</b>
		</td>
	</tr>
	<tr>
		<td>userID</td>
		<td><input type="text" name="userId"></td>
	</tr>
	<tr>
		<td>firstName</td>
		<td><input type="text" name="firstName"></td>
	</tr>
	<tr>
		<td>lastName</td>
		<td><input type="text" name="lastName"></td>
	</tr>
	<tr>
		<td>email</td>
		<td><input type="text" name="email"></td>
	</tr>
	<tr>
		<td>balance1</td>
		<td><input type="text" name="balance1"></td>
	</tr>
	<tr>
		<td>balance2</td>
		<td><input type="text" name="balance2"></td>
	</tr>
	<tr>
		<td><input type="submit" value="toQuery"></td>
		<td><input type="reset" value="reset"></td>
	</tr>
</table>


</form>

</body>
</html>