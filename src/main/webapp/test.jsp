<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test</title>
</head>
<body>
<%@include file="header.jsp" %>
<h5>this is first jsp page</h5>
<a href="login.jsp">Login</a><hr>
<form action="<%=request.getContextPath() %>/RegisterServlet" method="post">
<label for="user">User Id.</label>
<input type="text" id="user" name="user" placeholder="Enter User ID"><br><br>
<label for="phone">Mobile No.</label>
<input type="text" id="phone" name="phone" placeholder="Enter Mobile no."><br><br>
<input type="submit" value="Submit">

</form>
</body>
</html>