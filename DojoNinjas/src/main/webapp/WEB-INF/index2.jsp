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
<title>New Ninja</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="containerNewNinja">
		<div id="form">
			<h1>New Ninja</h1>
			<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
			    <p>
			        <form:select path="dojo">
			        	<c:forEach items="${allDojos}" var="dojo">
			        		<form:option value="${dojo.id}">
			        			<c:out value="${dojo.name}"></c:out>
			        		</form:option>
			        	</c:forEach>		
			        </form:select>
			    </p>
			    <p>
			    	First Name:
			        <form:input path="first_name" type="text"/>
			   		<form:errors path="first_name"/>
			    </p>
			    <p>
			    	Last Name:
			        <form:input path="last_name" type="text"/>	<!-- Remove Validations for testing while creating -->
			    	<form:errors path="last_name"/>
			        
			    </p>
			    <p>
			    	Age:
			        <form:input type ="number" path="age"/>	<!-- number input type is number -->
			    	<form:errors path="age"/>	
			    </p>
			    <input type="submit" value="Create"/>
			</form:form>    
		</div>
	</div>
</body>
</html>