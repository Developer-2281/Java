<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lookify!</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="containerDash">
		<div id="searchBar">
			<p><a href="/song/new">Add New</a> &nbsp &nbsp <a href="/search/topTen">Top Songs</a></p>
			
			<form action="/searchArtist">
				<input name="search" type="text"  placeholder="Search for Artist Name" id="searchBar">
				<input type="submit" value="Search"/>
			</form>
			
		</div>
		<div>
			<table>
			    <thead>
			        <tr>
			            <th>Name</th>
			            <th>Rating</th>
			            <th>Action</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${allSongs}" var="song">
			        <tr>
			            <td><a href="/song/${song.id}"><c:out value="${song.title}"/></a></td>
			            <td><c:out value="${song.rating}"/></td>
			            <td><a href="/song/delete/${song.id}">Delete</a><!--  &nbsp <a href="/song/edit/${song.id}">Edit</a>--></td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
	</div>
	
</body>
</html>