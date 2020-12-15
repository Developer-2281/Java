<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="containerShow">
		<h1><c:out value="${dojo.name}"></c:out> Ninjas</h1>
		<div>
			<table>
			    <thead>
			        <tr>
			            <th>First Name</th>
			            <th>Last Name</th>
			            <th>Age</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${dojo.ninjas}" var="ninja">
			        <tr>
			            <td><c:out value="${ninja.first_name}"/></td>
			            <td><c:out value="${ninja.last_name}"/></td>
			            <td><c:out value="${ninja.age}"/></td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
	</div>
</body>
</html>