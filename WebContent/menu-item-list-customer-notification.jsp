<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
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
			height="50" /> <a id=hmenu href="cart.html">Cart</a> <a id=hmenu
			href="menu-item-list-customer">Menu</a>
	</header>
	<br />
	<br />
	<div id="main">
		<p id="items">Menu Items</p>
		<p id="greenNotify">
			<b>Item added to Cart Successfully</b>
		</p>
		<table>
			<tr>
				<td id="name"><b>Name</b></td>
				<td id="menuCustomer"><b>Free Delivery</b></td>
				<td id="price" class="customer"><b>Price</b></td>
				<td class="customer"><b>Category</b></td>
				<td class="customer"><b>Action</b></td>
			</tr>
			<tr>
				<td id="name">Sandwich</td>
				<td id="menuCustomer">Yes</td>
				<td class="customer">Rs. 129.00</td>
				<td class="customer">Main Course</td>
				<td class="customer"><a
					href="menu-item-list-customer-notification.html">Add to cart</a></td>
			</tr>
			<tr>
				<td id="name">Pizza</td>
				<td id="menuCustomer">Yes</td>
				<td class="customer">Rs. 149.00</td>
				<td class="customer">Main Course</td>
				<td class="customer"><a
					href="menu-item-list-customer-notification.html">Add to cart</a></td>
			</tr>
			<tr>
				<td id="name">Burger</td>
				<td id="menuCustomer">Yes</td>
				<td class="customer">Rs. 99.00</td>
				<td class="customer">Main Course</td>
				<td class="customer"><a
					href="menu-item-list-customer-notification.html">Add to cart</a></td>
			</tr>

		</table>
	</div>

	<footer>
		<br /> Copyright &copy; 2019
	</footer>
</body>
</html>