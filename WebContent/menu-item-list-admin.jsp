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
		&nbsp;&nbsp;&nbsp;truYum&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img
			src="images/truyum-logo-light.png" align="middle" width="50"
			height="50" /> <a id=hmenu href="ShowMenuListAdmin">Menu</a>
	</header>
	<br />
	<br />
	<div id="main">
		<p id="items">Menu Items</p>
		<table>
			<tr id="trow">
				<td id="name"><b>Name</b></td>
				<td align="right" id="menu"><b>Price</b></td>
				<td><b>Active</b></td>
				<td><b>Date of Launch</b></td>
				<td><b>Category</b></td>
				<td><b>Free Delivery</b></td>
				<td><b>Action</b></td>
			</tr>


			<c:forEach var="menuItem" items="${menuItems}">
				<tr>
					<td id="name"><c:out value="${menuItem.name}"></c:out></td>
					<td id="price">Rs. <fmt:formatNumber minFractionDigits="2"
							value="${menuItem.price}"></fmt:formatNumber></td>
					<td><c:choose>
							<c:when test="${menuItem.active == true}">
						Yes
					</c:when>
							<c:otherwise> No
					</c:otherwise>
						</c:choose></td>
					<td><fmt:formatDate pattern="dd/MM/yyyy"
							value="${menuItem.dateOfLaunch}" /></td>
					<td><c:out value="${menuItem.category}"></c:out></td>
					<td><c:choose>
							<c:when test="${menuItem.freeDelivery == true}">
						Yes
					</c:when>
							<c:otherwise> No
					</c:otherwise>
						</c:choose></td>
					<td><a href="ShowEditMenuItem?menuItem=${menuItem.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<footer>
		<br /> Copyright &copy; 2019
	</footer>
</body>
</html>