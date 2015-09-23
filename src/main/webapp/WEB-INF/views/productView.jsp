<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
<h2 align="center">Product Display</h2>
<table align="center" border="2">
<tr><td>Product Id</td><td>Product Name</td><td>Product Price</td><td>Product Description</td></tr>
<tr>
	<td>${product.id}</td>
	<td>${product.name}</td>
	<td>${product.price}</<td>
	<td>${product.description}</<td>

</tr>
</table>

</body>
</html>