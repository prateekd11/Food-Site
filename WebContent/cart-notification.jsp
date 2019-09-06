<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="style/style.css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<header id="headr">
	&nbsp;&nbsp;&nbsp;truYum&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img
		src="images/truyum-logo-light.png" align="middle" width="50"
		height="50" /> <a id=hmenu href="cart.html">Cart</a> <a id=hmenu
		href="menu-item-list-customer.html">Menu</a>
</header>
<br />
<br />
<div id="main">

	<p id="items">Cart</p>
	<p id="greenNotify">
		<b>Item removed from Cart Successfully</b>
	</p>
	<table>
		<tr>
			<td id="name"><b>Name</b></td>
			<td id="menuCart"><b>Free Delivery</b></td>
			<td id="price" class="customer"><b>Price</b></td>
			<td class="customer"></td>
		</tr>
		<tr>
			<td id="name">Sandwich</td>
			<td id="menuCart">Yes</td>
			<td class="customer">Rs. 129.00</td>
			<td class="customer"><a href="cart-notification.html">Delete</a></td>
		</tr>
		<tr>
			<td id="name">Pizza</td>
			<td id="menuCart">Yes</td>
			<td class="customer">Rs. 149.00</td>
			<td class="customer"><a href="cart-notification.html">Delete</a></td>
		</tr>

		<tr>
			<td id="name"></td>
			<td id="menuCart"><b>Total</b></td>
			<td class="customer"><b>Rs. 278.00</b></td>
			<td class="customer"></td>
		</tr>

	</table>
</div>

<footer>
	<br /> Copyright &copy; 2019
</footer>
</body>
</html>