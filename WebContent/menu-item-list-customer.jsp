<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html >
<html>
<head>
<link href="style/style.css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Menu Items</title>
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
		<p id="items">Menu Items</p>
		<c:if test="${addCartStatus==true}">
			<p id="greenNotify">
				<b>Item added to Cart Successfully</b>
			</p>
		</c:if>

		<table>
			<tr>
				<td id="name"><b>Name</b></td>
				<td id="menuCustomer"><b>Free Delivery</b></td>
				<td id="price" class="customer"><b>Price</b></td>
				<td class="customer"><b>Category</b></td>
				<td class="customer"><b>Action</b></td>
			</tr>


			<c:forEach var="menuItem" items="${menuItems}">
				<tr>
					<td id="name"><c:out value="${menuItem.name}"></c:out></td>
					<td id="menuCustomer"><c:choose>
							<c:when test="${menuItem.freeDelivery == true}">
						Yes
					</c:when>
							<c:otherwise> No
					</c:otherwise>
						</c:choose></td>
					<td id="price">Rs. <fmt:formatNumber minFractionDigits="2"
							value="${menuItem.price}"></fmt:formatNumber></td>

					<td class="customer"><c:out value="${menuItem.category}"></c:out></td>

					<td class="customer"><a
						href="AddToCart?menuItemId=${menuItem.id}">Add to Cart</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<footer>
		<br /> Copyright &copy; 2019
	</footer>
</body>
</html>
