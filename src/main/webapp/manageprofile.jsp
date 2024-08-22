<%@page import="com.example.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="navber.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="StyleSheets/manageprofile.css">
</head>
<body>
<% User user=(User)session.getAttribute("user"); 

String username=user != null ? user.getUserName():"";
String email=user != null ? user.getEmail():"";
String password=user != null ? user.getPassword():"";
%>
<div class="out"> 
<div class="container">
<p><span>Name: </span><%=username %></p>
<p><span>Email: </span><%=email %></p>
<p><span>Password: </span><%=password %></p>
<div>
<a href="updateuser.jsp" class="edit">Edit</a>
<a href="deleteuser" class="delete">Delete</a>
<a href="index.jsp" class="edit">Back</a>
</div>
</div>
</div>
</body>
</html>