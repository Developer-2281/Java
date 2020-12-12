<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
	<h1>All Languages</h1>
	<div>
		<table>
		    <thead>
		        <tr>
		            <th>Language</th>
		            <th>Creator</th>
		            <th>Version</th>
		            <th>Action</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${allLangs}" var="language">
		        <tr>
		            <td><a href="/languages/${language.id}"><c:out value="${language.langName}"/></a></td>
		            <td><c:out value="${language.creator}"/></td>
		            <td><c:out value="${language.version}"/></td>
		            <td><a href="/languages/delete/${language.id}">Delete</a> &nbsp <a href="/languages/edit/${language.id}">Edit</a></td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
	</div>
	<h1>New Language</h1><!--action is the url to be directed to when the form is submitted-->
	<div id="form1">	
		<form:form action="/submitLang" method="post" modelAttribute="language">
		    <p><!-- path corresponds to the data entered into the model for Language and must match-->
		        <form:label path="langName">Language</form:label>
		        <form:errors path="langName"/>
		        <form:input path="langName"/>
		    </p>
		    <p>
		        <form:label path="creator">Creator</form:label>	<!-- Remove Validations for testing while creating -->
		        <form:errors path="creator"/>
		        <form:input path="creator"/>
		    </p>
		    <p>
		        <form:label path="version">Version</form:label>
		        <form:errors path="version"/>     
		        <form:input path="version"/>	<!-- number inputs are laid out different -->
		    </p>    
		    
		    	
		    <input type="submit" value="Submit"/>
		</form:form>    
	</div>
</body>
</html>