<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Secret Code</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="container">
		<form id="formBox" method="POST" action="/code">
			<p><c:out value="${error}"/></p>
			<label>What is the code? <input type="text" name="code"></label>
			<input type="submit" value="Try Code"></input>
		</form>
	</div>
</body>
</html>
