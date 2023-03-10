<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="by.ski.connection.DBCon, by.ski.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<% 
	User auth=(User)request.getSession().getAttribute("auth");
	if(auth!=null){
		request.setAttribute("auth",auth);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8">
<link type="text/css" rel="stylesheet" href="common.css" >
<title>Orders</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<h1>Orders</h1>
	
</body>
</html>