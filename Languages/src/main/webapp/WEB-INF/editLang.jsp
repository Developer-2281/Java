<%@ page isErrorPage="true" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    


<p><a href="/languages/delete/${language.id}">Delete</a> &nbsp <a href="/languages">Dashboard</a></p>
		    
<!--action is the url to be directed to when the form is submitted-->
	<div id="form1">	
		<form:form action="/languages/edit/${language.id}" method="post" modelAttribute="language">
		
   		    <input type="hidden" name="_method" value="put">
		    <p><!-- path corresponds to the data entered into the model for Language and must match-->
		        <form:label path="langName">Language</form:label>
		        <form:errors path="langName"/>
		        <form:input path="langName"/>
		    </p>
		    <p>
		        <form:label path="creator">Creator</form:label>	<!-- Remove Validations for testing while creating -->
		        <form:errors path="creator"/>
		        <form:input path="creator"/>
		    </p>
		    <p>
		        <form:label path="version">Version</form:label>
		        <form:errors path="version"/>     
		        <form:input path="version" value= "${language.version}"/>	<!-- number inputs are laid out different -->
		    </p>    
		    
		    	
		    <input type="submit" value="Submit"/>
		</form:form>    
	</div>
</body>
</html>