<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- Form Coding -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
</head>
<body>
	<div id="containerShowProd">
		<h1><c:out value="${product.name}"></c:out></h1>
		<h2>Categories:</h2>
		<ul>
			<c:forEach items="${product.categories}" var="category">
				<li><c:out value="${category.name}"/></li>
			</c:forEach>
		</ul>
	</div>
	Add a Category:
	<form action="/products" method="post">
	
		<input name="product_id" type="hidden" value="${product.id}" /> <!-- The current product's page we are on-->
		<!-- relationship join names -->
		<select name="category_id">
		
			<c:forEach items="${categories}" var="category">
				
					<option value="${category.id}"> ${category.name} </option>
												   <!--display-->			
			</c:forEach>		
			
		</select>
		
		<input type="submit" value="Add"/>
		
	</form>    
	
	
</body>
</html>