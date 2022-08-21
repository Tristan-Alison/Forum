<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav>
<div class="show-inline">
<form action="<c:url value='/NewsServlet'/>">
    <input type="submit" value="Les News" class="btn" />
</form>
<form action="<c:url value='/about'/>">
    <input type="submit" value="A propos" class="btn" />
</form>
<form action="<c:url value='/contact'/>">
    <input type="submit" value="Nous contacter" class="btn" />
</form>
<c:if test="${sessionScope.logged == null}">
	

<form action="<c:url value='/Application'/>">
    <input type="submit" value="Connexion" class="btn" />
</form>
</c:if>
<c:if test="${sessionScope.logged != null}">
	<a href="<c:url value='/Application?deco=yes'/>" class="btn-deco">Déconnection</a>
</c:if>


</div>
<br><br>
</nav>