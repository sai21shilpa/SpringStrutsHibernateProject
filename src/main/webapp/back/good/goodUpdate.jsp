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
<%@taglib prefix="s" uri="/struts-tags" %>
	<s:fielderror/>
	<s:form action="goodAction.action"  namespace="/ssh" method="post">
	<input type="hidden" name=submitFlag value="doUpdate"/>
		<table width=60% align="center" border="strike">
			<tr>
				<td colspan="4" align="center"><b>User Update</b></td>
			</tr>
			<tr>
				<td><b>goodId</b></td>
				<td><b>name</b></td>
				<td><b>description</b></td>
				<td><b>price</b></td>
			</tr>
			
			<tr>
				<td>${ret.goodId}</td>
				<td>${ret.name}</td>
				<td>${ret.description}</td>
				<td>${ret.price }</td>
			</tr>

			<tr>
				<td><input type="text" name="gqm.goodId" value="${ret.goodId}"/></td>
				<td><input type="text" name="gqm.name" value="${ret.name}"></td>
				<td><input type="text" name="gqm.description" value="${ret.description}"></td>
				<td><input type="text" name="gqm.price" value="${ret.price }"></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="Update">
					<input type="reset" value="reset">
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>