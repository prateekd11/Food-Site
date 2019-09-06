<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<p id="items">Cart</p>
		<p id="emptyCart">
			<b> No items in cart. Use 'Add to Cart' option in 
			<a href="ShowMenuListCustomer">Menu Item List</a>
			</b>
	</div>

	<footer>
		<br /> Copyright &copy; 2019
	</footer>
</body>
</html>