<%@ page import="by.ski.connection.DBCon"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="by.ski.model.User" %>
	
	
<% 
	User auth=(User)request.getSession().getAttribute("auth");
	if(auth!=null){
		response.sendRedirect("index.jsp");
	}
%>
	
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="login.css">
<title>Login</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div id="login">
		<h4 id="userWelcWrite">User Login:</h4>
		
		<form action="user-login" method="post">
			<label for="email">Email address:</label> 
			<input type="email"	id="email" name="email" 
				placeholder="Your Email..." /> 
			<label for="psw">Password:</label> 
			<input type="password" id="psw" name="psw" placeholder="*****" /> 
			<input type="submit" value="Send Data">
		</form>
	</div>
</body>
</html>