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
<title>Add Song</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="containerNewSong">
		<div>
			<p class="rightP"><a href="/dashboard">dashboard</a></p>
		</div><!--action is the url to be directed to when the form is submitted-->
		<div id="form">	
			<form:form action="/submitSong" method="post" modelAttribute="song">
			    <p><!-- path corresponds to the data entered into the model and must match-->
			        <form:label path="title">Title</form:label>
			   		<form:errors path="title"/>
			        <form:input path="title"/>
			    </p>
			    <p>
			        <form:label path="artist">Artist</form:label>	<!-- Remove Validations for testing while creating -->
			    	<form:errors path="artist"/>
			        <form:input path="artist"/>
			    </p>
			    <p>
			        <form:label path="rating">Rating (1-10)</form:label>
			    	<form:errors path="rating"/>	
			        <form:input type ="number" path="rating"/>	<!-- number inputs are laid out different -->
			    </p>    
			    
			    	
			    <input type="submit" value="Add Song"/>
			</form:form>    
		</div>
	</div>
</body>
</html>