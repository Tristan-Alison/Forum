<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
	<link rel="stylesheet" href="<c:url value="/ressources/css/style.css" />">
</head>
<jsp:include page="./inc/_header.jsp"/>
<jsp:include page="./inc/_nav.jsp"/>
<body>

<br>

<main>

	<form action="/Jpa/Application" method="POST">
	<br>
		<label>User:</label>
		<input type="text" placeholder="User" name="username"><br><br>
		<label>Password:</label>
		<input type="text" placeholder="Password" name="password"><br><br>
		<input type="submit" value="Login" class="btn">		
	</form>
<br>
<div class="error">
	<c:if test="${error}">
		User ou Password incorrect
	</c:if>
	
</div>
<form action="<c:url value='/NewsServlet'/>">
    <input type="submit" value="Retour" class="btn-orange" />
</form>
<br>
</main>
<jsp:include page="./inc/_footer.jsp"/>
</body>
</html>