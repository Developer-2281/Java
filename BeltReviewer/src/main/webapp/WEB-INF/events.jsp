<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ page isErrorPage="true" %> <!-- Binding Coding --> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="container">
		<p class="alignRight"><a href="/logout">Logout</a>
		<h1>Welcome, <c:out value="${user.first_name}"/> </h1>
		<h4>Here are some of the event in your state:</h4>
		<div>
			<table>
			    <thead>
			        <tr>
			            <th>Name</th>
			            <th>Date</th>
			            <th>Location</th>
			            <th>Host</th>
			            <th>Action/Status</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${allLangs}" var="language">
			        <tr>
			            <td><a href="/languages/${language.id}"><c:out value="${language.langName}"/></a></td>
			            <td><c:out value="${language.creator}"/></td>
			            <td><c:out value="${language.version}"/></td>
			            <td><a href="/languages/delete/${language.id}">Delete</a> &nbsp <a href="/languages/edit/${language.id}">Edit</a></td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
		<h4>Here are some of the events in other states:</h4>
		<div>
			<table>
			    <thead>
			        <tr>
			            <th>Name</th>
			            <th>Date</th>
			            <th>Location</th>
			            <th>Host</th>
			            <th>Action</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${allLangs}" var="language">
			        <tr>
			            <td><a href="/languages/${language.id}"><c:out value="${language.langName}"/></a></td>
			            <td><c:out value="${language.creator}"/></td>
			            <td><c:out value="${language.version}"/></td>
			            <td><a href="/languages/delete/${language.id}">Delete</a> &nbsp <a href="/languages/edit/${language.id}">Edit</a></td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
	
		<div>														
		    <form:form method="POST" action="/addEvent" modelAttribute="event">
		        <p>													
		            <form:label path="name">Name:</form:label>
		            <form:input type="text" path="name"/>
		        </p>
		        <p>
		            <form:label path="date">Date:</form:label>
		            <form:input type="date" path="date"/>
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
		        <input type="submit" value="Register!"/>
		    </form:form>
	    </div>  
	</div>  
</body>
</html>