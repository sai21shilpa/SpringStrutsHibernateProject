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
<form action="${pageContext.servletContext.contextPath}/ssh/goodAction.action" method="post" >
<input type="hidden" name=submitFlag value="toQuery"/>
<table width=25% align="center" border="strike">
	<tr>
		<td colspan="2" align="center">
		<b>USER QUERY PAGE</b>
		</td>
	</tr>
	<tr>
		<td>goodId</td>
		<td><input type="text" name="gqm.goodId"></td>
	</tr>
	<tr>
		<td>name</td>
		<td><input type="text" name="gqm.name"></td>
	</tr>
	<tr>
		<td>description</td>
		<td><input type="text" name="gqm.description"></td>
	</tr>
	<tr>
		<td>price1</td>
		<td><input type="text" name="gqm.price1"></td>
	</tr>
	<tr>
		<td>price2</td>
		<td><input type="text" name="gqm.price2"></td>
	</tr>
	<tr>
		<td><input type="submit" value="toQuery"></td>
		<td><input type="reset" value="reset"></td>
	</tr>
</table>


</form>

</body>
</html>