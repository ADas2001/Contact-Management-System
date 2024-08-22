<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navber.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container{
	font-family: Arial, Helvetica, sans-serif;
	background-color: #f0f0f0;
	margin:0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: start;
	height: 100vh;
}
.form-container{
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0,0,0,0.1);
	width: 300px;
	text-align: center;
	margin-top: 50px;
}
.form-container h1{
	margin-bottom: 20px;
	color: #333;
}
.form-container input[type="text"],
.form-container input[type="email"],
.form-container input[type="password"]
{
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}
.form-container input[type="submit"]
{
	background-color: #4CAF50;
	color: white;
	border: none;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin-top: 10px;
	border-radius: 4px;
	cursor: pointer;
}
.form-container input[type="submit"]:hover
{
	background-color: #45a049;
}
</style>
</head>
<body>
<div class="container">
	<div class="form-container">
	<h1>Register</h1>
	<form action="register" method="post">
	<label>Enter Your Name:</label>
	<input type="text" name="username" placeholder="Enter Your Name">
	<br>
	<label>Enter Your Mail Id:</label>
	<input type="email" name="email" placeholder="Enter Your Email Id">
	<br>
	<label>Enter Your Password:</label>
	<input type="password" name="password" placeholder="Enter Your Password">
	<br>
	<input type="submit" value="Register">
	<br>
	</form>
	</div>
	</div>
</body>
</html>