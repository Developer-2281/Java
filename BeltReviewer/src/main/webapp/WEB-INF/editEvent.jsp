<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Event</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>  


<p><a href="/events">Events</a> &nbsp <a href="/logout">Logout</a></p>
		    
<!--action is the url to be directed to when the form is submitted-->
	<div id="form1">
		<h1>${event.name}</h1>
		<h3> Edit Event </h3>
	   	<p class="alert1"><form:errors path="event.*"/></p><!-- shows all model errors here -->	
	   	
		<form:form method="post" action="/events/${event.id}/edit/" modelAttribute="event">
			<input type="hidden" name="_method" value="put" />
		    <form:input path="host" value="${userId}" type="hidden"/>
			<p>													
		    	<form:label path="name">Name: </form:label>
		    	<form:input type="text" path="name"/>
			</p>
		    <p>
		   		<form:label path="event_date">Date:</form:label>
		 		<form:input type="date" path="event_date"/>
			</p>
			<p>
		 		<form:label path="location">Location:</form:label>
				<form:input type="text" path="location"/>
			</p>
			<p>
				<form:label path="state">State:</form:label>
				<form:select path="state">
					<form:option value="MI"></form:option>
					<form:option value="OH"></form:option>
					<form:option value="IN"></form:option>
					<form:option value="CA"></form:option>
					<form:option value="WA"></form:option>
					<form:option value="ID"></form:option>
					<form:option value="NY"></form:option>
					<form:option value="FL"></form:option>
					<form:option value="TX"></form:option>
					<form:option value="AZ"></form:option>
					<form:option value="NM"></form:option>
					<form:option value="OK"></form:option>
					<form:option value="MS"></form:option>
					<form:option value="SC"></form:option>
				</form:select>
			</p>
			<input type="submit" value="Edit"/>
		</form:form>
	</div>
</body>
</html>