<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="containerSongInfo">
		<p id="rightP"><a href="/dashboard">dashboard</a></p>
		
	<h3><c:out value="${song.title}"/></h3>
	<p>Title: <c:out value="${song.title}"/></p>
	<p>Artist: <c:out value="${song.artist}"/></p>
	<p>Rating: <c:out value="${song.rating}"/></p>
	<a href="/song/delete/${song.id}"><input type =button value="Delete"></a>
	</div>
</body>
</html>