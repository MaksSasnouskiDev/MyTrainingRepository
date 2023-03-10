<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="by.ski.model.User" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<%
	User attr=(User)request.getSession().getAttribute("auth");	
	if(attr!=null){
		request.setAttribute("auth", attr);
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="header.css">
<title>Header</title>
</head>

<body>

	<header>
		<a id="shop_name_header" 
			href="index.jsp" >E-Commerce Shopping Cart</a>
		<nav>
			<ul id="links_header">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="cart.jsp">Cart</a></li>
				
				<%if(attr!=null){%>
					<li><a href="orders.jsp">Orders</a></li>
					<li><a href="log-out">Logout</a></li>
				<%}else{%>
					<li><a href="login.jsp">Login</a></li>
				<%}%>
			</ul>
		</nav>
	</header>
	
</body>
</html>