<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="petHtmlStyles.css">
<title>List of Pets</title>
</head>
<body>
<h1>Pet List</h1>
</body>
<body class = "tableBackground">
<form method = "post" action = "editPetsListServlet">
	<table>
		<c:forEach items="${requestScope.allPets}" var="currentpet">
		<tr>
			<td><input type="radio" name="id" value="${currentpet.id}"></td>
			<td>${currentpet.type}</td>
			<td>${currentpet.name}</td>
			<td>${currentpet.owner}</td>
		</tr>
		</c:forEach>		
	</table>
	<input type = "submit" value = "Edit Selected Pet" name = "doThisToPet">
	<input type = "submit" value = "Delete Selected Pet" name = "doThisToPet">
	<input type = "submit" value = "Add New Pet" name = "doThisToPet">
	</form>
</body>
</html>