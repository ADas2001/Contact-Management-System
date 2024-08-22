<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="navber.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="StyleSheets/addcontact.css">
</head>
<body>
	<div class="addcontact">
	<h1>Enter Contact Details</h1>
	<form action="addcontact" method="post">
	<input type="text" name="contactname" placeholder="Enter Contact Name">
	<br>
	<input type="number" name="contactnumber" placeholder="Enter Contact Number">
	<br>
	<div class="submit">
	<input type="submit"><input type="reset">
	</div>
	<br>
	</form>
	</div>
</body>
</html>