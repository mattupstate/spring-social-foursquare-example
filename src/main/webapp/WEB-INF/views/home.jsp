<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
	<ul>
		<li><a href="<c:url value="/signout" />">Sign Out</a></li>
	</ul>
	<h3>Venues near Washington Square Park, New York City</h3>
	<ul>
	<c:forEach items="${venues}" var="venue">
		<li><c:out value="${venue.name}"/></li>
	</c:forEach>
	</ul>	
	</body>
</html>