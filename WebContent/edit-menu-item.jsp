<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="style/style.css" rel="stylesheet" />
<title>Edit Menu Item</title>
</head>
<body>
	<header id="headr">
		&nbsp;&nbsp;&nbsp;truYum&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img
			src="images/truyum-logo-light.png" align="middle" width="50"
			height="50" /> <a id=hmenu href="ShowMenuListAdmin">Menu</a>
	</header>
	<div id="mainEdit">
		<p id="items">Edit Menu Item</p>
		<br />
		<form method="post" action="EditMenuItem" id="formEdit">
			<label for="fname"><b>Name</b></label><br /> <input type="hidden"
				name="menuID" value="${menuItem.id}"> <input type="text"
				id="fname" name="firstname"
				value="<c:out value="${menuItem.name}"/>"> <br /> <br /> <label
				for="fname"><b>Price (Rs.)</b></label> <label id="statedit"><b>Active</b></label>

			<label id="editGrp"><b>Date of Launch</b></label> <label
				id="editGrp1"><b>Category</b></label> <br /> <input type="number"
				id="fname" name="price"
				value="<fmt:formatNumber minFractionDigits="2" value="${menuItem.price}"/>">

			<input type="radio" name="status" id="radioLeft" value="true"
				${menuItem.active==true?'checked':''}> Yes &nbsp;&nbsp; <input
				type="radio" name="status" ${menuItem.active==false?'checked':''}
				value="false">No <input type="text" name="date"
				id="inputline"
				value="<fmt:formatDate  pattern="MM/dd/yyyy" value="${menuItem.dateOfLaunch}"/>">
			<select id="inputselect" name="category">
				<option ${menuItem.category=="Starters"?'selected':''}
					value="Starters">Starters</option>
				<option ${menuItem.category=="Main Course"?'selected':''}
					value="Main Course">Main Course</option>
				<option ${menuItem.category=="Deserts"?'selected':''}
					value="Deserts">Deserts</option>
				<option ${menuItem.category=="Drinks"?'selected':''} value="Drinks">Drinks</option>
			</select> <br /> <br /> <input type="checkbox" name="delivery"
				${menuItem.freeDelivery==true?'checked':''} value="true">Free
			Delivery <br /> <br />
			<button value="submit">Save</button>
		</form>
	</div>
	<footer>
		<br /> Copyright &copy; 2019
	</footer>

</body>
</html>