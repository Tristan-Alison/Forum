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
<c:if test="${!sessionScope.logged.admin}">
	<c:forEach items="${listeNewsFive}" var="news">
		<fieldset>
			<h3>${news.title}</h3>
			<div>${news.texte}</div>
		</fieldset>
		<br>
	</c:forEach>
</c:if>

<!-- SI ADMIN -->
<c:if test="${sessionScope.logged.admin}">
	<!-- ADD -->
	<fieldset>
		<form action="/Jpa/NewsServlet?type=add" method="POST">
			<label>Title</label><br>
			<input type="text" name="title"><br>
			<label>Texte</label><br>
			<textarea name="texte" rows="5" cols="80"></textarea>
			<br>
			<input type="submit" value="add" class="btn">
		</form>
	</fieldset>
	
	<br>
	<!-- UPDATE -->
	<c:forEach items="${listeNews}" var="news">
		<fieldset>
		<div class="show-inline">
			<form action="/Jpa/NewsServlet?type=modify&id=${news.id}" method="POST">
				<input type="text" name="title" value="${news.title}"><br>
				<textarea name="texte" rows="4" cols="80">${news.texte} </textarea><br>
				<input type="submit" value="change" class="btn-orange">
			</form>
				<form action="/Jpa/NewsServlet?type=delete&id=${news.id}" method="POST">
				<input type="submit" value="delete" class="btn-red">
		</form>
		</div>
		</fieldset>
		<!-- DELETE -->

		<br>
	</c:forEach>

</c:if>
</main>
<jsp:include page="./inc/_footer.jsp"/>	
</body>
</html>