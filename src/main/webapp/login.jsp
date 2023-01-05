<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<%@include file="header.jsp" %>
<form action="<%=request.getContextPath() %>/jspLogin" method="post">
<h3>Enter your Credentials for login</h3>
<label for="userID">User ID:-</label>
<input type="text" name="userid" placeholder="Enter User ID" required><br><br>
<label for="phone">Mobile No.:-</label>
<input type="phone" name="phone" placeholder="Enter Phone" required><br><br>
<input type="submit" value="Login">
</form>

</body>
</html>