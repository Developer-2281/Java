<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ page isErrorPage="true" %> <!-- Binding Coding --> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration & Login Page</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div>
	    <h2 class="alert1"><c:out value="${flasherror}"/></h2>
	    <h1>Register!</h1>
	    <p class="alert1"><form:errors path="user.*"/></p>
	    																	<!-- When combining forms both -->
	    <form:form method="POST" action="/registration" modelAttribute="user"> <!--need to account for the model-->
	        <p>													<!--attribute in the controller, user in this case-->
	            <form:label path="first_name">First Name:</form:label>
	            <form:input type="text" path="first_name"/>
	        </p>
	        <p>
	            <form:label path="last_name">Last Name:</form:label>
	            <form:input type="text" path="last_name"/>
	        </p>
	        <p>
	            <form:label path="email">Email:</form:label>
	            <form:input type="email" path="email"/>
	        </p>
	        <p>
	            <form:label path="location">Location:</form:label>
	            <form:input type="text" path="location"/>
	        </p>
	        <p>
	            <form:label path="state">State:</form:label>
	            <form:select path="state">
	            	<form:option value="MI"></form:option>
	            	<form:option value="OH"></form:option>
	            	<form:option value="IN"></form:option>
	            	<form:option value="CA"></form:option>
	            	<form:option value="WA"></form:option>
	            	<form:option value="ID"></form:option>
	            	<form:option value="NY"></form:option>
	            	<form:option value="FL"></form:option>
	            	<form:option value="TX"></form:option>
	            	<form:option value="AZ"></form:option>
	            	<form:option value="NM"></form:option>
	            	<form:option value="OK"></form:option>
	            	<form:option value="MS"></form:option>
	            	<form:option value="SC"></form:option>
	            </form:select>
	        </p>
	        <p>
	            <form:label path="password">Password:</form:label>
	            <form:password path="password"/>
	        </p>
	        <p>
	            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
	            <form:password path="passwordConfirmation"/>
	        </p>
	        <input type="submit" value="Register!"/>
	    </form:form>
    </div>    
    <div>
	    <h1>Login</h1>
	    <p class="alert1"><c:out value="${error}" /></p>
	    <form method="post" action="/login">
	        <p>
	            <label for="email">Email</label>
	            <input type="text" id="email" name="email"/>
	        </p>
	        <p>
	            <label for="password">Password</label>
	            <input type="password" id="password" name="password"/>
	        </p>
	        <input type="submit" value="Login!"/>
	    </form>    
    </div>
</body>
</html>