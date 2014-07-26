<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="javascript">
	var myRequest;
	function t1(){
		var goodId = document.getElementById("goodId").value;
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
			myRequest=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
			myRequest=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		myRequest.onreadystatechange = t2;
		myRequest.open("GET", "${pageContext.servletContext.contextPath}/ssh/createAjax.action?goodId="+goodId, true);
		myRequest.send(null);
		function t2(){
			if (myRequest.readyState == 4){
				var ret = myRequest.responseText;
				document.all("checkDiv").innerHTML = ret;
			}
		}
	}

</script>

</head>


<body>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<form action="${pageContext.servletContext.contextPath}/ssh/goodAction.action"   method="post">
	
	<input type="hidden" name=submitFlag value="toCreate"/>
		<table width=60% align="center" border="strike">
			<tr>
				<td colspan="6" align="center"><b>User Create</b></td>
			</tr>
			<tr>
				<td><b>goodId</b></td>
				<td><b>name</b></td>
				<td><b>description</b></td>
				<td><b>price</b></td>
			</tr>

			<tr>
				<td><input type="text" name="gqm.goodId" id="goodId" onblur="t1();"></td>
				<td><input type="text" name="gqm.name"></td>
				<td><input type="text" name="gqm.description"></td>
				<td><input type="text" name="gqm.price"></td>
			</tr>
			<tr>
				<td><div id="checkDiv"></div></td>
			</tr>
			<tr>
				<td colspan="6" align="center">
					<input type="submit" value="create">
					<input type="reset" value="reset">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>