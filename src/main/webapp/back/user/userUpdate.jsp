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
	<jsp:useBean id="oldb" class="edu.iit.fenghuang.ssh.vo.UserModel" scope="request"/>
	<jsp:useBean id="newb" class="edu.iit.fenghuang.ssh.vo.UserModel" scope="request"/>
	<jsp:setProperty property="*" name="newb"/>
	<c:if test="${newb.submitFlag == 'doUpdate' }">
		<jsp:forward page="/UserServlet"></jsp:forward>
	</c:if>
	<form action="${pageContext.servletContext.contextPath}/back/user/userUpdate.jsp" method="post">
	<input type="hidden" name=submitFlag value="doUpdate"/>
		<table width=60% align="center" border="strike">
			<tr>
				<td colspan="6" align="center"><b>User Update</b></td>
			</tr>
			<tr>
				<td><b>userId</b></td>
				<td><b>password</b></td>
				<td><b>firstName</b></td>
				<td><b>lastName</b></td>
				<td><b>email</b></td>
				<td><b>balance</b></td>
			</tr>
			
			<tr>
				<td>${oldb.userId }</td>
				<td>${oldb.password }</td>
				<td>${oldb.firstName }</td>
				<td>${oldb.lastName }</td>
				<td>${oldb.email }</td>
				<td>${oldb.balance }</td>
			</tr>

			<tr>
				<td><input type="text" name="userId" value="${oldb.userId }"></td>
				<td><input type="text" name="password" ></td>
				<td><input type="text" name="firstName"></td>
				<td><input type="text" name="lastName"></td>
				<td><input type="text" name="email"></td>
				<td><input type="text" name="balance"></td>
			</tr>
			<tr>
				<td colspan="6" align="center">
					<input type="submit" value="Update">
					<input type="reset" value="reset">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>