<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="containerTopTen">
		<p id="rightP"><a href="/dashboard">dashboard</a></p>
		<h2>Top Ten Songs</h2>
		<div id="topTenBox">
			<table>
			    <thead>
			        <tr>
			            <th>Rating 1-10</th>
			            <th>Song Title</th>
			            <th>Artist</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${songs}" var="song">
			        <tr>
			            <td><c:out value="${song.rating}"/></td>
			            <td><a href="/song/${song.id}"><c:out value="${song.title}"/></a></td>
			            <td><c:out value="${song.artist}"/></td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
	</div>
</body>
</html>