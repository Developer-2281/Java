<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey Index</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="container">
		<form id="formBox" method="POST" action="/result">
		<p><c:out value="${error}"/></p>
		<p>Your Name: <input type="text" name="name1"></p>
		<p>Dojo Location: <select name="location">
			<option value="San Jose">San Jose</option>
			<option value="Burbank">Burbank</option>
			<option value="Chicago">Chicago</option>
			</select>
		</p>
		<p> Favorite Language<select name="language">
			<option value="python">Python</option>
			<option value="Java">Java</option>
			<option value="Other">Other</option>
			</select>
		</p>
		<p>Comment (optional): <textarea rows="4" cols="45" name="text"></textarea></p>
		 <p><input type="submit" value="Button"></p>
		</form>
	</div>
</body>
</html>