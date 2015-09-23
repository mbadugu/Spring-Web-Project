<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Register Form</h2>
		<s:form action="registerProcess" method="post" commandName="register">
		
		
		<table>
				<tr><td>Username</td><td><s:input path="username"/></td><td><font color="red"><s:errors path="username"/></font></td></tr>
				<tr><td>Firstname</td><td><s:input path="firstname"/></td><td><font color="red"><s:errors path="firstname"/></font></td></tr>
				<tr><td>Lastname</td><td><s:input path="lastname"/></td></tr>
				<tr><td>City</td><td><s:select items="${cities}" path="city"></s:select></td></tr>
				<tr><td>State</td><td><s:select items="${states}" path="state"></s:select></td></tr>  
				<tr><td><input type="submit" value="REGISTER"/></td></tr>
			</table>
			
		</s:form>
</body>
</html>


