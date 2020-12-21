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
<!----------------------------------------- Link Bar ------------------------------------------------------->
	<div id="container">
		<p class="alignRight"><a href="/logout">Logout</a>
		
		<!-- Edit/Delete Brute Force Security Flash Error -->
	    <h2 class="alert1"><c:out value="${flasherror}"/></h2> 
<!----------------------------------------- Events in your State ------------------------------------------->
		<h1>Welcome, <c:out value="${user.first_name} ${user.last_name}"/> </h1>
		<h4> Here are some of the event in your state:</h4>
		<div>
			<table>
			    <thead>
			        <tr>
			            <th>Name</th>
			            <th>Date</th>
			            <th>Location</th>
			            <th>State</th>
			            <th>Host</th>
			            <th>Action/Status</th>
			        </tr>
			    </thead>
			    <tbody> <!-- Forlooping the Event Object "${events}" passed from the jsp file/>-->
			    			<!--  Then  -->
			    		<!-- Testing is the event.state is equal to the users state -->
			    	<c:forEach items="${events}" var="event"> 
			    		<c:if test="${event.state == user.state}">
				       <!-- IF equal the following lines of code will be extracted -->
				        <tr>
				            <td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
				            <td><c:out value="${event.event_date}"/></td>
				            <td><c:out value="${event.location}"/></td>
				            <td><c:out value="${event.state}"/></td>
				            <td><c:out value="${event.host.first_name}"/></td>
				           <!-- IF the loggedin user's id matches the host id of the event they can see edit and delete --> 
				            <c:choose> 
								<c:when test="${event.host.id == userId}">							
				            		<td><a href="/events/${event.id}/delete/">Delete</a> &nbsp <a href="/events/${event.id}/edit">Edit</a></td>
				        		</c:when>
				        		<c:otherwise>
				        				<td><a href="/events/${event.id}/join">Join</a> &nbsp <a href="/events/${event.id}/cancel">Cancel</a></td>
				        		</c:otherwise>
				        	</c:choose>
				        	
				        </tr>
				        
						</c:if>
					</c:forEach>
			    </tbody>
			</table>
		</div>
<!---------------------------------------- Events in other States ----------------------------------------->
		<h4>Here are some of the events in other states:</h4>
		<div>
			<table>
			    <thead>
			        <tr>
			            <th>Name</th>
			            <th>Date</th>
			            <th>Location</th>
			            <th>State</th>
			            <th>Host</th>
			            <th>Action</th>
			        </tr>
			    </thead>
			    <tbody><!-- On the second line of code below if the event and user state do not match loop runs -->
			        <c:forEach items="${events}" var="event">
			    		<c:if test="${event.state != user.state}">
					        
					        <tr>
					            <td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
					            <td><c:out value="${event.event_date}"/></td>
					            <td><c:out value="${event.location}"/></td>
					            <td><c:out value="${event.state}"/></td>
					            <td><c:out value="${event.host.first_name}"/></td>
					            
					            <c:choose> 
									<c:when test="${event.host.id == userId}">							
					            		<td><a href="/events/${event.id}/delete/">Delete</a> &nbsp <a href="/events/${event.id}/edit">Edit</a></td>
					        		</c:when>
					        		<c:otherwise>
					        			<td><a href="/events/${event.id}/join">Join</a> &nbsp <a href="/events/${event.id}/cancel">Cancel</a></td>
					        		</c:otherwise>
				        		</c:choose>
					        </tr>
						</c:if>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
	<!------------------------------------- add an event --------------------------------------------------->
		<div>					
			<h3>Add an Event</h3>
	    	<p class="alert1"><form:errors path="event.*"/></p><!-- shows all model errors here -->
		    <form:form method="POST" action="/addEvent" modelAttribute="event">
		    <form:input path="host" value="${userId}" type="hidden"/>
		    	<p>													
		            <form:label path="name">Name:</form:label>
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
		        <input type="submit" value="Register!"/>
		    </form:form>
	    </div>  
	</div>  
</body>
</html>