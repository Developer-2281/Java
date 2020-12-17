<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- Form Coding -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> <!-- Binding Coding -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="containerNewProduct">
		<div id="form">
			<h1>New Product</h1>
			<!--action is the url to be directed to when the form is submitted-->
			<form:form action="/products/new" method="post" modelAttribute="product">
				<p>  <!-- path corresponds to the data entered into the model and must match-->
			        Name:
					<form:input type="text" path="name"/>
			   		<form:errors path="name"/>
			   	</p>
				<p>
					Description: <!--textarea coding for form form -->
					<form:textarea rows="4" cols="45" path="description"/>
			   		<form:errors path="description"/>
			   		
				</p>
			   	 <p>Price $
			        <form:input type="number" path="price"/>
			   		<form:errors path="price"/>
			   	 </p>
			    <input type="submit" value="Create"/>
			</form:form>    
		</div>
	</div>
</body>
</html>