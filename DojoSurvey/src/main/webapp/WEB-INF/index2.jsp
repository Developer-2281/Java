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
		<div id="formBox2">
		<h2>Submitted Info</h2>
		<p>Name: <c:out value="${name1}"/></p>
		<p>Dojo Location: <c:out value="${location}"/></p>
		<p>Favorite Language: <c:out value="${language}"/></p>
		<p>Comment: <c:out value="${text}"/></p>
		</div>
	</div>
</body>
</html>