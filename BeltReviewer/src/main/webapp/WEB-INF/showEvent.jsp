<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ page isErrorPage="true" %> <!-- Binding Coding --> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<!--------------------------------Show Event -------------------------------->
	<div id="showEventContainer">
			<p class="alignRight"><a href="/events">Events</a> &nbsp <a href="/logout">Logout</a></p>
			<h1><c:out value="${event.name}"/></h1>
			<p>Host: <c:out value="${event.host.first_name} ${event.host.last_name}"/></p>
			<p>Date: <c:out value="${event.event_date}"/>
			</p>
			<p>Location: <c:out value="${event.location}, ${event.state}"/></p>
			
			<c:if test="${event.host.id == userId}">
				<a href="/events/${event.id}/edit">Edit Event</a>
				<p><a href="/events/${event.id}/delete"><input type="submit" value="Delete"></a> <!-- button -->
				<input type="hidden" name="_method" value="delete">								 <!-- button -->
			</p></c:if>
		</div>
		
		<!-------------------------------- People Attending ---------------------------------->
		
		<div>
			<p>People who are attending this event: </p>
			<table>
			    <thead>
			        <tr>
			            <th>Name</th>
			            <th>Location</th>
			        </tr>
			    </thead>
			    <tbody>
			    	<c:forEach items="${event.hostedEvents}" var="user">
				    	<tr>
					     	<td><c:out value="${user.first_name}"/></td>
					    	<td><c:out value="${user.location}"/></td>
					  	</tr>
					</c:forEach>
			    </tbody>
			</table>
		</div>
		
		<!-------------------------------- Message Wall ---------------------------------->
		
		<div>
			<h1>Message Wall</h1>
			<ul>	
				<c:forEach items="${wallposts}" var="message">
					<c:if test="${event.id == message.wall.id}">	
						<li><c:out value="${message.poster.first_name} says: ${message.msg_text}"/></li>					
					</c:if>
				</c:forEach>
			</ul>
		</div>
		
		<!-------------------------------- Message Wall Add a Comment---------------------------------->
		<div>
							
	    	<p class="alert1"><form:errors path="event.*"/></p><!-- shows all model errors here -->
	    	
		    <form:form method="POST" action="/events/${event.id}" modelAttribute="message">
		    <form:hidden path="poster" value="${user.id}"/>
		    <form:hidden path="wall" value="${event.id}"/>
		    	<p> Add a Comment</p>
		    	<p>													
		            <form:textarea path="msg_text" rows="4" cols="45" />
				</p>
			    <input type="submit" value="Submit"/>
			</form:form>
		</div>
	</div>
</body>
</html>