<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList, java.util.List, by.ski.connection.DBCon, 
	by.ski.model.User, by.ski.model.Cart, by.ski.dao.ProductDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}
ArrayList<Cart>cart_list=(ArrayList<Cart>)session.getAttribute("cart-list");
List<Cart> cartProduct=null;

if(cart_list!=null){
	DBCon dbCon=new DBCon();
	ProductDao prodDao=new ProductDao(dbCon.getConnection());
	prodDao.getCartProducts(cart_list);
	request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="cart.css">
<title>Cart</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div id="totalPriceContainer">
		<h2 id="price">Total Price: $452</h2>
		<a id="checkOutAnchor" href="#">Check it Out!</a>	
	</div>

	<table id="tableCart">
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Description</th>
				<th scope="col">Price</th>
				<th scope="col">Amount</th>				
				<th scope="col">Cost</th>
				<th scope="col">Remove item</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Women Shoes</td>
				<td>Shoes</td>
				<td>$45</td>
				
				<form method="post" id="remove" action="#">
					<td>
						<input type="number" name="amount" placeholder="1">
					</td>
					<td>
						<input type="number" name="cost" placeholder="1">
					</td>
					<td>
						<input type="submit" value=Remove>
					</td>
				</form>
			</tr>
		</tbody>
	</table>
</body>
</html>