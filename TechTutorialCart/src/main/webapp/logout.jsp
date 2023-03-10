<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page import="by.ski.connection.DBCon, by.ski.model.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.removeAttribute("auth");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link type="text/css" rel="stylesheet" href="common.css">
<title>Logout</title>
</head>
<body>
	<h2>Logout</h2>
</body>
</html>