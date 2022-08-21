<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
	<link rel="stylesheet" href="<c:url value="/ressources/css/style.css" />">
</head>
<body>


<jsp:include page="./inc/_header.jsp"/>
<jsp:include page="./inc/_nav.jsp"/>
<main>
<br>
<!-- SI NON ADMIN -->

	<!-- ADD -->

		<p>Pour nous contacter envoyez nous un mail à : News@gmail.com</p>

	<br>
	
</main>
<jsp:include page="./inc/_footer.jsp"/>
</body>
</html>