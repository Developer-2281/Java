<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><c:out value="${language.langName}"/></h1>
	<p>Creator: <c:out value="${language.creator}"/></p>
	<p>Version: <c:out value="${language.version}"/></p>
	<a href="/languages/edit/${language.id}">Edit Language</a>
	<p><input type="hidden" name="_method" value="delete">
	   <a href="/languages/delete/${language.id}"><input type="submit" value="Delete"></a>
	</p>
	
</body>
</html>