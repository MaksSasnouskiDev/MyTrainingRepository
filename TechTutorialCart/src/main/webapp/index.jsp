<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="by.ski.connection.DBCon, by.ski.model.User
		,by.ski.dao.ProductDao,by.ski.model.Product, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<% 
	User auth=(User)request.getSession().getAttribute("auth");
	if(auth!=null){
		request.setAttribute("auth",auth);
	}
	DBCon dbCon=new DBCon();
	ProductDao productDao=new ProductDao(dbCon.getConnection());
	List<Product>products= productDao.getAllProducts();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link type="text/css" rel="stylesheet" href="index.css">
<title>Index Welcome to Shopping Cart!</title>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="card-header">All products:</div>
		
	<div class="gallery">
		
		<% 
		if(!products.isEmpty()){
			for(Product p:products){
		%>
 			<div class="content">
				<img src="images/<%=p.getImage()%>" class="pict" alt="shoes">
			<h3 class="productName"><%=p.getName()%></h3>
			
			<div class="productDescription">			
			<%=p.getDescription()%>
			</div>
			<h4 class="priceIndex">$<%=p.getPrice()%></h4>
			
			<div class="linksIndex">				
				<a class="anchorBuy" href="#">Buy Now</a>
				<a class="anchorToCart" href="add-to-cart?id=<%=p.getId()%>">
					Add to Cart</a>				
			</div>
		</div>

		<%
			}
		}
		%>	
	
	</div>
</body>
</html>