<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html >
<html>
<head>
<link href="style/style.css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body id="bdy">
	<header id="headr">
		&nbsp;&nbsp;&nbsp;truYum&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img
			src="images/truyum-logo-light.png" align="middle" width="50"
			height="50" /> <a id=hmenu href="ShowCart">Cart</a> <a id=hmenu
			href="ShowMenuListCustomer">Menu</a>
	</header>
	<br />
	<br />
	<div id="main">


		<c:if test="${cartStatus==true}">
			<p id="greenNotify">
				<b>Item removed from Cart Successfully</b>
			</p>
		</c:if>

		<p id="items">Cart</p>
		<table>
			<tr>
				<td id="name"><b>Name</b></td>
				<td id="menuCart"><b>Free Delivery</b></td>
				<td id="price" class="customer"><b>Price</b></td>
				<td class="customer"></td>
			</tr>
			<c:forEach var="cartItem" items="${cartItems}">
				<tr>
					<td id="name"><c:out value="${cartItem.name}"></c:out></td>
					<td id="menuCustomer"><c:choose>
							<c:when test="${cartItem.freeDelivery == true}">
						Yes
					</c:when>
							<c:otherwise> No
					</c:otherwise>
						</c:choose></td>
					<td id="price">Rs. <fmt:formatNumber minFractionDigits="2"
							value="${cartItem.price}"></fmt:formatNumber></td>

					<td class="customer"><a
						href="RemoveCart?cartItemId=${cartItem.id}">Delete</a></td>
				</tr>
			</c:forEach>

			<tr>
				<td id="name"></td>
				<td id="menuCustomer" class="customer" align="center"><b>Total</b></td>
				<td class="customer" align="center"><b><c:out
							value="${total}" /></b></td>
				<td class="customer"></td>
			</tr>

		</table>
	</div>

	<footer>
		<br /> Copyright &copy; 2019
	</footer>
</body>
</html>