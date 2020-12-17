<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- Form Coding -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Page</title>
</head>
<body>
	<div id="containerShowCat">
		<h1><c:out value="${category.name}"></c:out></h1>
		<h2>Products:</h2>
		<ul>
			<c:forEach items="${category.products}" var="product">
				<li><c:out value="${product.name}"/></li>
			</c:forEach>
		</ul>
	</div>
	Add a Product:
	<form action="/categories" method="post">
	
		<input name="category_id" type="hidden" value="${category.id}" /> <!-- The current category 's page we are on-->
		<!-- relationship join names -->
		<select name="product_id">
		
			<c:forEach items="${products}" var="product">
				
					<option value="${product.id}"> ${product.name} </option>
												   <!--display-->			
			</c:forEach>		
			
		</select>
		
		<input type="submit" value="Add"/>
		
	</form>    
	
	
	
	
</body>
</html>