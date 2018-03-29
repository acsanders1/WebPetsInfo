<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="petHtmlStyles.css">
<title>Edit Pet</title>
</head>
<body>
	<h1>Edit Pet Entry</h1>
	<form action = "editPetServlet" method = "post">
		<div class = "container">
		Pet Type: <input type = "text" name = "type" value = "${petToEdit.type}">
		Pet Name: <input type = "text" name = "name" value = "${petToEdit.name}">
		Pet Owner: <input type = "text" name = "owner" value = "${petToEdit.owner}">
		<input type = "hidden" name = "id" value = "${petToEdit.id}">
		</div>
		<input type = "submit" value = "Save Edited Pet">
		<div>
			<img src="images/kitty.jpg" alt="pets" class="pets">
		</div>
	</form>
</body>
</html>