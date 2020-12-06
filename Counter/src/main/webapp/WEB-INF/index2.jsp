<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Current visit count</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="wrapper">
		<ul>
			<li><h2>You Have visited <a href="/your_server">your_server/</a> <c:out value="${count}"/> times</h2></li>
			<li><h2><a href="/your_server">Test another visit?</a></h2></li>
		</ul>
	</div>
</body>
</html>